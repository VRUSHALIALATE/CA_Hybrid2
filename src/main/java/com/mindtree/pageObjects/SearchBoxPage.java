package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.SearchBoxPageLocators;

public class SearchBoxPage {
		
	       WebDriver driver = null;
	       
	       public SearchBoxPage(WebDriver driver)
	       {
	    	   this.driver = driver;
	       }
	       
	       public WebElement getSearchBox()
	       {
	    	   return driver.findElement(SearchBoxPageLocators.searchBox);
	       }
	      
	       public WebElement getTitle()
	       {
	    	   return driver.findElement(SearchBoxPageLocators.title);
	       }
	       
	       public List<WebElement> getProductList()
	       {
	    	   return driver.findElements(SearchBoxPageLocators.prodyctList);
	       }
}
