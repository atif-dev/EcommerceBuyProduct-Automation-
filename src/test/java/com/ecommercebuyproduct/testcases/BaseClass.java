package com.ecommercebuyproduct.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ecommercebuyproduct.pageobjects.BaseClassPageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void main(String browser) throws InterruptedException {
		
		logger = Logger.getLogger("EcommerceWebForm");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com/index.php");
		
		BaseClassPageObjects bc = new BaseClassPageObjects(driver);
		bc.clickSignIn();
		
		bc.InputEmail("1239@gmal.com");
		bc.InputPassword("951753");
		bc.login();
		Thread.sleep(2000);
		
		WebElement womanLink = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		Actions action = new Actions(driver);
		
		action.moveToElement(womanLink).build().perform();
		//Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//*[@id=\"nav-flyout-icp\"]/div[2]/a[3]")).click();
		
		
		bc.clickTShirtsLink();
		Thread.sleep(2000);
		
		WebElement product = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
		action.moveToElement(product).build().perform();
		
		Thread.sleep(2000);
		bc.clickMoreLink();
		
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}

