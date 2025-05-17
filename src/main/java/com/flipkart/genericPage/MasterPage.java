package com.flipkart.genericPage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MasterPage {
	public static WebDriver driver;
	public Properties prop;
	public Properties or;
	public Properties td;
	
	//Constructor Implementation
	public MasterPage() throws Exception{
		//configuration Properties File Implementation
		
		
		FileInputStream ip=new FileInputStream(".\\src\\main\\java\\com\\flipkart\\repository\\configuration.properties");
		prop=new Properties();
		prop.load(ip);
		
		FileInputStream fs=new FileInputStream(".\\src\\main\\java\\com\\flipkart\\repository\\locators.properties");
		or=new Properties();
		or.load(fs);
		
		FileInputStream ts=new FileInputStream(".\\src\\main\\java\\com\\flipkart\\repository\\testdata.properties");
		td=new Properties();
		td.load(ts);
		
		//Added latest WebDriver MAnager dependency into pom.xml
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		
		}
		else
			System.out.println("No browser details found");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
			
		
	}
}


