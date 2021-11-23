package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.mindtree.appUIStrore.WishListPageLocators;

public class WishListPage {

	   WebDriver driver = null;
       
       public WishListPage(WebDriver driver)
       {
    	   this.driver = driver;
       }
       
       public WebElement getWishList()
       {
    	   return driver.findElement(WishListPageLocators.wishlist);
       }
       
       public List<WebElement> getProductList()
       {
    	   return driver.findElements(WishListPageLocators.productList);
       }
       
       public WebElement getPopup()
       {
    	   return driver.findElement(WishListPageLocators.popup);
       }
}
