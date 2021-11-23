package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.HomePageLocators;

public class HomePage {
	
       WebDriver driver = null;
       
       public HomePage(WebDriver driver)
       {
    	   this.driver = driver;
       }
             
       public WebElement getSignIn()
       {
    	   return driver.findElement(HomePageLocators.signIn);
       }
      
}
