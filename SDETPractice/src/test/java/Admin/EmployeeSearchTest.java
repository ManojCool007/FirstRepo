package Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmployeeSearchTest {
	//Search Employee
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String Browser = prop.getProperty("browser");
		String Url = prop.getProperty("url");
		String UN = prop.getProperty("username");
		String PWD = prop.getProperty("password");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		driver.get(Url);
		driver.findElement(By.name("user")).sendKeys(UN);
		driver.findElement(By.name("password")).sendKeys(PWD);
		driver.findElement(By.name("btnlogin")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		driver.findElement(By.xpath("//span[text()='Employee']")).click();
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Sheet1");
		String value = sh.getRow(1).getCell(0).getStringCellValue();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys(value);
		Thread.sleep(2000);
		driver.quit();
	}

}
