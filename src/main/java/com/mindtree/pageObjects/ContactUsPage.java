package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.ContactUsPageLocators;

public class ContactUsPage {


    WebDriver driver = null;
    
    public ContactUsPage(WebDriver driver)
    {
 	   this.driver = driver;
    }
    
    public WebElement getEmail()
    {
 	   return driver.findElement(ContactUsPageLocators.email);
    }
    
    public WebElement getName()
    {
 	   return driver.findElement(ContactUsPageLocators.name);
    }
    
    
    public WebElement getMessage()
    {
 	   return driver.findElement(ContactUsPageLocators.message);
    }
    
    
    public WebElement getSend()
    {
 	   return driver.findElement(ContactUsPageLocators.send);
    }
    
    
    public WebElement getContactUs()
    {
 	   return driver.findElement(ContactUsPageLocators.contactUS);
    }
    
    public WebElement getTitle()
    {
 	   return driver.findElement(ContactUsPageLocators.title);
    }
    
    
}
