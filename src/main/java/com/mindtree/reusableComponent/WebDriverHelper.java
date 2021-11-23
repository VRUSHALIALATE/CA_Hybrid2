package com.mindtree.reusableComponent;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mindtree.utility.ReadPropertyFile;

public class WebDriverHelper {

	static ReadPropertyFile rp = null;
	static WebDriver driver = null;
   
	
	//LANCHING THE DRIVR
	public static void launchingBrowser() throws Exception {

		rp = new ReadPropertyFile();
        
		
		if (rp.getBrowser().equalsIgnoreCase("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			System.setProperty("webdriver.chrome.driver", rp.getDriverPath());

			driver = new ChromeDriver(options);
		System.out.println(driver);
		}

		else if (rp.getBrowser().equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", rp.getDriverPath());

			driver = new InternetExplorerDriver();
		}

		else if (rp.getBrowser().equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", rp.getDriverPath());

			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	
	//RETURN THE DRIVER
	public static WebDriver getDriver() {
		return driver;
	}
}
