package com.ecommercebuyproduct.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommercebuyproduct.pageobjects.TestCase1;

public class TC_01 extends BaseClass {
	
	@Test
	public void TC1() throws InterruptedException {
		
		
		TestCase1 tc1 = new TestCase1(driver);
		tc1.increaseQuantity();
		tc1.selectSize();
		tc1.selectColor();
		
		tc1.addToCart();
		Thread.sleep(5000);
		
		tc1.proceedToCheckout();
		Thread.sleep(2000);
		
		tc1.proceedToCheckout2();
		Thread.sleep(2000);
		tc1.proceedToCheckout3();
		
		Thread.sleep(2000);
		tc1.checkTerms();
		tc1.proceedToCheckout4();
		
		Thread.sleep(2000);
		tc1.clickPayBankWire();
		Thread.sleep(2000);
		tc1.confirmOrder();
		
		Thread.sleep(2000);
		
		String expectedText = "Your order on My Store is complete.";
		String actualText = tc1.getConfirmOrderText();
		if(expectedText.equals(actualText)) {
			logger.info("Test Case passed");
			Assert.assertTrue(true);
		}else {
			logger.info("Test Case failed");
			Assert.assertTrue(false);
		}
	}

}
