package com.ecommercebuyproduct.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.ecommercebuyproduct.pageobjects.TestCase2;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_02 {
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@Test
	public void TC2(String browser) throws InterruptedException {
		
		logger = Logger.getLogger("EcommerceBuyProduct");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}else if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else if(browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com/index.php");
		
		WebElement womanLink = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(womanLink).build().perform();
		
		TestCase2 tc2 = new TestCase2(driver);
		tc2.clickTShirtsLink();
		Thread.sleep(2000);
		
		WebElement product = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
		action.moveToElement(product).build().perform();
		
		tc2.addToWishList();
		Thread.sleep(6000);
		
		String expectedAlert = "You must be logged in to manage your wishlist.";
		String actualAlert = tc2.getAlertText();
		if(actualAlert.equals(expectedAlert)) {
			logger.info("Error Message is displayed");
			logger.info("Test case passed");
			Assert.assertTrue(true);
		}else {
			logger.info("Test Case failed");
			Assert.assertTrue(false);
		}
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		
		driver.quit();
	}
	
}
