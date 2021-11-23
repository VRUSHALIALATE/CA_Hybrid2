package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.appUIStrore.GiftCardPageLocators;

public class GitCardPage {


    WebDriver driver = null;
    
    public GitCardPage(WebDriver driver)
    {
 	   this.driver = driver;
    }
    
    public WebElement getGiftCard()
    {
 	   return driver.findElement(GiftCardPageLocators.giftcard);
    }
    
    public WebElement getTitle()
    {
 	   return driver.findElement(GiftCardPageLocators.title);
    }
   
}
