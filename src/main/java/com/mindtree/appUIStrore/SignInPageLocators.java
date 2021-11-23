package com.mindtree.appUIStrore;

import org.openqa.selenium.By;

public class SignInPageLocators {

    public static By email =    By.id("CustomerEmail");
	
	public static By password = By.id("CustomerPassword");
	
	public static By signInSummitButton = By.cssSelector("input[value = 'Sign In']");
	
	public static By errorMessageTitle = By.xpath("//li[text() ='Incorrect email or password.']");
	
}
