package week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlingwindow {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Click and Confirm new Window Opens");
		driver.findElement(By.xpath("//span[@class=\"ui-button-text ui-c\"]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindowHandles=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindowHandles.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(lstwindowHandles.get(0));
		System.out.println("Find the number of opened tabs");
		driver.findElement(By.xpath("(//span[@class=\"ui-button-text ui-c\"])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		int size = windowHandles2.size();
		System.out.println(size);
		System.out.println(driver.getTitle());
		driver.close();
		System.out.println(driver.getTitle());
		driver.close();
		System.out.println("No of tabs open "+ windowHandles2.size());
		System.out.println("Close all windows except Primary");
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String>lstwindowHandles2=new ArrayList<String>(windowHandles3);
		driver.switchTo().window(lstwindowHandles2.get(3));
		System.out.println(driver.getTitle());
		driver.switchTo().window(lstwindowHandles2.get(2));
		System.out.println(driver.getTitle());
		driver.switchTo().window(lstwindowHandles2.get(1));
		System.out.println(driver.getTitle());
		driver.switchTo().window(lstwindowHandles2.get(0));
		System.out.println("No of tabs open "+ windowHandles3.size());
		System.out.println("Wait for 2 new tabs to open");
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]")).click();
		Set<String> windowHandles4 = driver.getWindowHandles();
		List<String>lstwindowHandles3=new ArrayList<String>(windowHandles4);
		driver.switchTo().window(lstwindowHandles3.get(2));
		System.out.println(driver.getTitle());
	    driver.close();
	    driver.switchTo().window(lstwindowHandles3.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(lstwindowHandles3.get(0));
		System.out.println("No of tabs open "+ windowHandles4.size());

	}

}
