package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.appUIStrore.ShopByCatagoryPageLocators;

public class ShopByCatagoryPage {

	
	  WebDriver driver = null;
      
      public ShopByCatagoryPage(WebDriver driver)
      {
   	   this.driver = driver;
      }
      
      public WebElement getShopByCatagory()
      {
   	   return driver.findElement(ShopByCatagoryPageLocators.shopbycategory);
      }
     
      public List<WebElement> getBirthdayCatagory()
      {
   	   return driver.findElements(ShopByCatagoryPageLocators.birthdaygift);
      }
      
      public List<WebElement> getBirthdayProductList()
      {
   	   return driver.findElements(ShopByCatagoryPageLocators.product);
      }
      
      public WebElement getAddtoWish()
      {
   	   return driver.findElement(ShopByCatagoryPageLocators.addtowishlist);
      }
      
      public WebElement getRemove()
      {
   	   return driver.findElement(ShopByCatagoryPageLocators.remove);
      }
      
}
