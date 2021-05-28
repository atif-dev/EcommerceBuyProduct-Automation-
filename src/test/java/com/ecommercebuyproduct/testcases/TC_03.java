package com.ecommercebuyproduct.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommercebuyproduct.pageobjects.TestCase3;

public class TC_03 extends BaseClass {
	
	@Test
	public void TC3() throws InterruptedException {
		
		Thread.sleep(1000);
		
		TestCase3 tc3 = new TestCase3(driver);
		String expectedQuanity = "1";
		String actualQuantity = tc3.getQuantity();
		if(actualQuantity.equals(expectedQuanity)) {
			logger.info("Quantity 1 is verified");
		}else {
			logger.info("Quantity 1 is not verified");
			Assert.assertTrue(false);
		}
		
		tc3.selectSize();
		Thread.sleep(1000);
		tc3.selectColor();
		Thread.sleep(1000);
		
		tc3.addToCart();
		Thread.sleep(3000);
		
		tc3.proceedToCheckout();
		Thread.sleep(2000);
		
		tc3.increaseQuantity();
		
		Thread.sleep(3000);
		String actualTotalPrice = tc3.getActualTotalPrice();
		String expectedTotalPrice = tc3.getExpectedTotalPrice();
		if(actualTotalPrice.equals(expectedTotalPrice)) {
			logger.info("Total Price is reflecting correct");
			logger.info("Test Case passed");
			Assert.assertTrue(true);
		}else {
			logger.info("Test Case failed");
			Assert.assertTrue(false);
		}
		
		
	}

}
