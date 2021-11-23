package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.ChristmasGiftPageLocators;

public class ChristmasGiftPage {

 WebDriver driver = null;
     
     public ChristmasGiftPage(WebDriver driver)
     {
  	   this.driver = driver;
     }
     
     public WebElement getAddToCart()
     {
  	   return driver.findElement(ChristmasGiftPageLocators.addCart);
     }
     
     public WebElement getCheckOut()
     {
  	   return driver.findElement(ChristmasGiftPageLocators.checkout);
     }
     
     public WebElement getChristmas()
     {
  	   return driver.findElement(ChristmasGiftPageLocators.christmas);
     }
     
     public List<WebElement> getProductList()
     {
  	   return driver.findElements(ChristmasGiftPageLocators.product);
     }
     
     public WebElement getReturnCard()
     {
  	   return driver.findElement(ChristmasGiftPageLocators.returnCart);
     }
     
     
     public WebElement getReturnInfo()
     {
  	   return driver.findElement(ChristmasGiftPageLocators.returnInformation);
     }
     
     public WebElement getShoppingCartTitle()
     {
  	   return driver.findElement(ChristmasGiftPageLocators.shoppingCartTitle);
  	   
     }
     
     public WebElement getPop()
     {
  	   return driver.findElement(ChristmasGiftPageLocators.popup);
     }
        
}
