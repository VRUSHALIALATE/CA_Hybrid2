package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.HomePageLocators;
import com.mindtree.appUIStrore.PersionalizedGiftPageLocators;

public class PersonalizedGiftPage {

    WebDriver driver = null;
    
    public  PersonalizedGiftPage(WebDriver driver)
    {
 	   this.driver = driver;
    }
          
    public WebElement getPersionaizedGiftMenu()
    {
 	   return driver.findElement(PersionalizedGiftPageLocators.persionalizedGift);
    }
    
    public WebElement getSortBy()
    {
 	   return driver.findElement(PersionalizedGiftPageLocators.sortBy);
    }
    
    public WebElement getDropDownOption()
    {
 	   return driver.findElement(PersionalizedGiftPageLocators.highToLow);
    }
    
    
    public WebElement getGetFirstItem()
    {
 	   return driver.findElement(PersionalizedGiftPageLocators.firstBook);
    }
    
    public WebElement getAddToCard()
    {
 	   return driver.findElement(PersionalizedGiftPageLocators.addToCard);
    }
    
}
