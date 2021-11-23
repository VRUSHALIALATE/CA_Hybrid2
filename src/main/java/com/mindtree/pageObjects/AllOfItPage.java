package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.appUIStrore.AllOfItPageLocators;


public class AllOfItPage {

     WebDriver driver = null;
     
     public AllOfItPage(WebDriver driver)
     {
  	   this.driver = driver;
     }
     
     public WebElement getAllOfIt()
     {
  	   return driver.findElement(AllOfItPageLocators.allofit);
     }
     
     public WebElement getProduct()
     {
  	   return driver.findElement(AllOfItPageLocators.product);
     }
     
     public WebElement getTitle()
     {
  	   return driver.findElement(AllOfItPageLocators.title);
     }
         
}
