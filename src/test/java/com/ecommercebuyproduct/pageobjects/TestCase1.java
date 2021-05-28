package com.ecommercebuyproduct.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestCase1 {

	 WebDriver driver;
	    public TestCase1(WebDriver driver){
	        PageFactory.initElements(driver, this);
	    }
	    
	@FindBy(how = How.ID, using = "group_1")
	WebElement sizeDropDown;
	
	@FindBy(how = How.ID, using = "color_14")
	WebElement color;
	
	@FindBy(how = How.NAME, using = "Submit")
	WebElement addToCart;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"quantity_wanted_p\"]/a[2]")
	WebElement plus;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	WebElement proceedCheckout;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/p[2]/a[1]")
	WebElement proceedCheckout2 ;
	
	@FindBy(how = How.NAME, using = "processAddress")
	WebElement proceedCheckout3;
	
	@FindBy(how = How.ID, using = "cgv")
	WebElement termsCheck;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"form\"]/p/button")
	WebElement proceedCheckout4 ;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	WebElement payBankWire ;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cart_navigation\"]/button")
	WebElement confirmOrder ;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div/p/strong")
	WebElement confirmOrderText ;
	
	public void increaseQuantity() {
		plus.click();
	}
	
	public void selectSize() {
		Select size = new Select(sizeDropDown);
		size.selectByVisibleText("L");
	}
	
	public void selectColor() {
		color.click();
	}
	
	public void addToCart() {
		addToCart.click();
	}
	
	public void proceedToCheckout() {
		proceedCheckout.click();
	}
	
	public void proceedToCheckout2() {
		proceedCheckout2.click();
	}
	
	public void proceedToCheckout3() {
		proceedCheckout3.click();
	}
	
	public void checkTerms() {
		termsCheck.click();
	}
	
	public void proceedToCheckout4() {
		proceedCheckout4.click();
	}
	
	public void clickPayBankWire() {
		payBankWire.click();
	}
	
	public void confirmOrder() {
		confirmOrder.click();
	}
	
	public String getConfirmOrderText() {
		return confirmOrderText.getText();
	}
	
	
}
