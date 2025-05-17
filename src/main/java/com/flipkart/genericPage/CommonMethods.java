package com.flipkart.genericPage;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonMethods extends MasterPage {
	
	public CommonMethods() throws Exception{
		super();
	}
	
	//Click WebElement
		public void clickWebElement(String xpathkey) {
			driver.findElement(By.xpath(or.getProperty(xpathkey))).click();
		}
		
		//Enter Data
		public void enterData(String xpathkey , String testdata) {
			driver.findElement(By.xpath(or.getProperty(xpathkey))).sendKeys(td.getProperty(testdata));
		}
		
		
		//Mouse Hover
		public void moveToElements(String xpathkey) {
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath(or.getProperty(xpathkey)))).build().perform();
		
		}
		
		//Clcik List of WebElement
		public void clickListElement(String xpathkey,String testdata) {
			List<WebElement> listOfElements = driver.findElements(By.xpath(or.getProperty(xpathkey)));
			System.out.println("Size of list"+listOfElements.size());
			for(int i=0 ; i < listOfElements.size(); i++) {
				if(listOfElements.get(i).getText().equalsIgnoreCase(td.getProperty(testdata))) {
					listOfElements.get(i).click();
				}
			}
			
		}
		
		//search Items
		public void searchItem(String xpathkey) {
			WebElement ser=driver.findElement(By.xpath(or.getProperty(xpathkey)));
			Actions act=new Actions(driver);
			act.sendKeys(ser, Keys.ENTER).build().perform();
			
		}
		
	//New Window Handles
		public void switchToNewWindow(String xpathkay) {
			
			 String originalWindow = driver.getWindowHandle();

		        // Wait for the new window and switch to it
		        Set<String> allWindows = driver.getWindowHandles();
		        for (String windowHandle : allWindows) {
		            if (!windowHandle.equals(originalWindow)) {
		                driver.switchTo().window(windowHandle);
		                break;
		            }
		        }

		        // Now interact with the elements in the new window
		        JavascriptExecutor js = (JavascriptExecutor) driver;

		        // Scroll to the form and locate the button
		        js.executeScript("window.scrollBy(0, 300);"); // Adjust scrolling as needed
		        clickWebElement(xpathkay);
		       
		}
}
