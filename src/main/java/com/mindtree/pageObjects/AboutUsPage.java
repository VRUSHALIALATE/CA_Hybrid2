package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.appUIStrore.AboutUsPageLocators;

public class AboutUsPage {


    WebDriver driver = null;
    
    public AboutUsPage(WebDriver driver)
    {
 	   this.driver = driver;
    }
    
    public WebElement getAboutMenu()
    {
 	   return driver.findElement(AboutUsPageLocators.about);
    }
    
    public WebElement getTitle()
    {
 	   return driver.findElement(AboutUsPageLocators.title);
    }
    
}
