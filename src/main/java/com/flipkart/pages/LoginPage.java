package com.flipkart.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.genericPage.CommonMethods;

public class LoginPage extends CommonMethods {

	JavascriptExecutor jse=(JavascriptExecutor) driver;
	public LoginPage() throws Exception {
		super();
		
	}
	
	//Click On Login
	public void clickOnLogin() {
		clickWebElement("Login");
		//handleLogger("LoginPage" , "Clicked on Email");
	}
	
	//Enter Email or Phonenumber
		public void enterEmail() {
			enterData("enter_email" ,"TestData1");
			//handleLogger("LoginPage" , "Entered Email");
		}
	//Enter OTP	
		
	//Click on Request OTP
		public void clickOnRequest() {
			clickWebElement("req_otp");
			//handleLogger("LoginPage" , "Clicked on Email");
		}
	//Search
	
	
	public void searchItem() {
		enterData("search" ,"TestData2");
		searchItem("search");
		System.out.println("clicked on search");
		}
	
	//
	public void clickOnItem() throws Exception{
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,400)");
	//	Thread.sleep(1000);
		System.out.println("Before Item clicked");
		clickWebElement("clickItem");
		System.out.println("Item searchds");
		
	}
	
	//Add to Cart
	public void addToCart() {
		
		switchToNewWindow("addtocart");
		
		/* WebElement button = null;
	        for (int i = 0; i < 10; i++) { // Limit to 10 attempts to avoid infinite scrolling
	            try {
	                button = driver.findElement(By.xpath("//form/button[contains(@Class, 'QqFHMw') and text()='Buy Now']"));
	                if (button.isDisplayed()) {
	                    break;
	                }
	            } catch (Exception e) {
	                jse.executeScript("window.scrollBy(0, 300);"); // Scroll by 300 pixels
	                try {
	                    Thread.sleep(500); // Wait briefly to allow the page to update
	                } catch (InterruptedException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }

	        // If button is found, click it
	        if (button != null) {
	            button.click();
	            System.out.println("Button clicked successfully.");
	        } else {
	            System.out.println("Button not found after scrolling.");
	        }*/
		// Locate the button
   /*    WebElement button = driver.findElement(By.xpath("//form/button[contains(@class, 'QqFHMw') and text()='Buy Now']"));

		//jse.executeScript("window.scrollBy(0,500)");
		System.out.println("Inside add after scrolling");
		jse.executeScript("arguments[0].scrollIntoView(true);", button);
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.elementToBeClickable(button));

	        // Click the button
	        button.click();
		
	//	clickWebElement("addtocart"); */
	}
	
	//Enter e-mail/mobile for check out
	public void checkout() throws Exception {
		enterData("email_mobile","TestData1");
		clickWebElement("continue");
		Thread.sleep(5000);
		clickWebElement("LoginButton");
		System.out.println("Vlicked on login");
		
		
	}
	
	public void deliveryItem() throws Exception  {
		clickWebElement("delivery");
		//jse.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		System.out.println("before email");
		enterData("mobile","TestData3");
		Thread.sleep(2000);
	/*	WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@Class='QqFHMw VuSC8m _7Pd1Fp']")));
		element.click();*/
		  jse.executeScript("window.scrollBy(0, 300);");
		System.out.println("before ");
		clickWebElement("continue_But");
		System.out.println("After ");
		Set<String> allWindowsID=driver.getWindowHandles();
		Iterator<String> abc=allWindowsID.iterator();
		String win1=abc.next();
		String win2=abc.next();
		String win3=abc.next();
		driver.switchTo().window(win3);
		clickWebElement("accept");
		
		
		
		
	}
	
}
