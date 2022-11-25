package week4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
	Alert al = driver.switchTo().alert();
	Thread.sleep(2000);
	al.accept();
	String text = driver.findElement(By.xpath("//span[text()='You have successfully clicked an alert']")).getText();
	System.out.println(text);
	WebElement sh = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]"));
		sh.click();
		Alert ds = driver.switchTo().alert();
		Thread.sleep(2000);
		ds.dismiss();
		String text2 = driver.findElement(By.xpath("//span[text()='User Clicked : Cancel']")).getText();
		System.out.println(text2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		WebElement cl = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]"));
		cl.click();
		String text3 = cl.getText();
		System.out.println(text3);
		WebElement dl = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[5]"));
		dl.click();
		String text4 = driver.findElement(By.xpath("//p[contains(text(),'Unless you close')]")).getText();
		System.out.println(text4);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(@class,'close ui-corner-all')])[2]")).click();
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
		Alert fl = driver.switchTo().alert();
		fl.sendKeys("HARIGANESH");
		Thread.sleep(2000);
		String text5 = fl.getText();
		System.out.println(text5);
		Thread.sleep(2000);
		al.accept();
		String text6 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(text6);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[7]")).click();
		Thread.sleep(2000);
        WebElement f2 = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[10]"));
		f2.click();
		 String print = driver.findElement(By.xpath("//h5[text()='Sweet Alert (Confirmation)']")).getText();
		 System.out.println(print);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[8]")).click();
		Thread.sleep(2000);
        WebElement f3 = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']"));
        f3.click();
		Thread.sleep(2000);
		WebElement f4 = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-plus']"));
		f4.click();
		Thread.sleep(2000);
		WebElement f5 = driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]"));
        f5.click();
        String print1 = driver.findElement(By.xpath("//h5[text()='Minimize and Maximize']")).getText();
		System.out.println(print1);
		
	}

}
