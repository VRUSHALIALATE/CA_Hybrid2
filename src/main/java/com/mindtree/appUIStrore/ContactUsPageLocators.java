package com.mindtree.appUIStrore;

import org.openqa.selenium.By;

public class ContactUsPageLocators {

	public static By contactUS = By.linkText("Contact us");

	public static By message = By.id("ContactFormMessage-page-contact-template-0");

	public static By name = By.id("ContactFormName-page-contact-template-0");

	public static By email = By.id("ContactFormEmail-page-contact-template-0");

	public static By send = By.className("btn");

	public static By title = By.cssSelector(".section-header__title.appear-delay");
}
