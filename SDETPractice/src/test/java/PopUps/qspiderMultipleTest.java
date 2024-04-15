package PopUps;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class qspiderMultipleTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Browser Windows']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//button[text()='Click to open multiple popup windows']")).click();
		WeddriverUtility util=new WeddriverUtility();
		util.switchwindow(driver, "SignUpPage");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("password")).sendKeys("abc@1234");
		driver.findElement(By.id("confirm-password")).sendKeys("abc@1234");
		Thread.sleep(2000);
		util.switchwindow(driver, "Login");
		driver.findElement(By.id("username")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("password")).sendKeys("abc@2124");
		Thread.sleep(2000);
		util.switchwindow(driver, "SignUp");
		driver.findElement(By.id("username")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("password")).sendKeys("abc@2124");
		Thread.sleep(2000);
	}

}
