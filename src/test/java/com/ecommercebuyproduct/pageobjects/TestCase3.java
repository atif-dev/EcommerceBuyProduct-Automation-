package com.ecommercebuyproduct.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestCase3 {
	
	WebDriver driver;
	public TestCase3(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(how = How.ID, using = "group_1")
	WebElement sizeDropDown;
	
	@FindBy(how = How.ID, using = "color_14")
	WebElement color;
	
	@FindBy(how = How.NAME, using = "Submit")
	WebElement addToCart;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	WebElement proceedCheckout;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cart_quantity_up_1_4_0_509368\"]")
	WebElement plusQuantity;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[6]/span")
	WebElement actualTotalPrice;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/span[1]/span[1]")
	WebElement unitPrice;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/input[1]")
	WebElement quantity2;
	
	public String getQuantity() {
		
		String quantityValue = quantity.getAttribute("value");
		return quantityValue;
		
	}
	
	public void selectSize() {
		Select size = new Select(sizeDropDown);
		size.selectByVisibleText("M");
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
	
	public void increaseQuantity() {
		plusQuantity.click();
	}
	
	public String getActualTotalPrice() {
		return actualTotalPrice.getText();
	}
	
	public String getExpectedTotalPrice() {
		
		String unitPriceValue = unitPrice.getText();
		unitPriceValue =  unitPriceValue.substring(1);
		double unitPriceValueDouble = Double.parseDouble(unitPriceValue);
		
		String quantity = quantity2.getAttribute("value");
		int quantityInt = Integer.parseInt(quantity);
		
		double expectedTotalPriceDouble = unitPriceValueDouble * quantityInt;
		String expectedTotalPriceString = Double.toString(expectedTotalPriceDouble);
		expectedTotalPriceString = "$" + expectedTotalPriceString;
		return expectedTotalPriceString;
		
	}
	
	

}
