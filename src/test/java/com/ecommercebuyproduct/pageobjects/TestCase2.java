package com.ecommercebuyproduct.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCase2 {
	
	 WebDriver driver;
	    public TestCase2(WebDriver driver){
	        PageFactory.initElements(driver, this);
	    }
	    
	@FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement tShirtsLink;
	    
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[3]/div[1]/a")
	WebElement addWishList;
	    
	@FindBy(how = How.XPATH, using = "//*[@id=\"category\"]/div[2]/div/div/div/div/p")
	WebElement alertText;
	    
	public void  clickTShirtsLink() throws InterruptedException {
			Thread.sleep(2000);
			tShirtsLink.click();
			
	}
	    
	public void addToWishList() {
	    	addWishList.click();
	    }
	    
	public String getAlertText() {
		return alertText.getText();
	}  

}
