package com.ecommercebuyproduct.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BaseClassPageObjects {
	
	WebDriver ldriver;
	public BaseClassPageObjects(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(how = How.ID, using = "email")
	WebElement loginEmail; 
	
	@FindBy(how = How.ID, using = "passwd")
	WebElement loginPassword;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")
	WebElement loginBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement tShirtsLink;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]")
	WebElement moreLink;
	
	public void clickSignIn() {
		signIn.click();
	}
	
	public void InputEmail(String email) {
		loginEmail.sendKeys(email);
	}
	
	public void InputPassword(String password) {
		loginPassword.sendKeys(password);
	}
	
	public void login() {
		loginBtn.click();
	}
	
	public void  clickTShirtsLink() throws InterruptedException {
		Thread.sleep(2000);
		tShirtsLink.click();
		
	}
	
	public void clickMoreLink() {
		moreLink.click();
	}

}
