package com.flipkart.tests;

import org.testng.annotations.Test;


import com.flipkart.pages.LoginPage;
public class LoginTest {
	
	@Test
	public void LoginTest() throws Exception {
		LoginPage lp=new LoginPage();
		
		//lp.clickOnLogin();
		//lp.enterEmail();
		//lp.clickOnRequest();
		Thread.sleep(2000);
		lp.searchItem();
		//Thread.sleep(2000);
		
		lp.clickOnItem();
		lp.addToCart();
		lp.checkout();
		lp.deliveryItem();
	}

}
