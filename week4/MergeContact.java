package week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();  
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get("http://leaftaps.com/opentaps/control/login"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();	 
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow =new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(lstwindow.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("hari");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		WebElement msg = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]"));
		driver.executeScript("arguments[0].click()", msg);
		driver.switchTo().window(lstwindow.get(0));
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String>lstwindow1 =new ArrayList<String>(windowHandles1);
		driver.switchTo().window(lstwindow1.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("ganesh");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		WebElement msg1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]"));
		driver.executeScript("arguments[0].click()", msg1);
		driver.switchTo().window(lstwindow1.get(0));
		driver.findElement(By.xpath("//td//a[text()='Merge']")).click();
		Alert simple = driver.switchTo().alert();
		simple.accept();
		System.out.println(driver.getTitle());
		driver.quit();
}

}