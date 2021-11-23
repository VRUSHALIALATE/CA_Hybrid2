package com.mindtree.appUIStrore;

import org.openqa.selenium.By;

public class PersionalizedGiftPageLocators {

	public static By persionalizedGift = By.cssSelector("*[data-dropdown-rel='personalized-gifts']");
	
	public static By sortBy = By.id("sortBy");
	
	public static By highToLow = By.cssSelector("option[value='price-descending']");
	
	public static By firstBook = By.xpath("//*[@data-product-id = '6226030133446']");

	public static By addToCard = By.xpath("//button[@name = 'add']");	
}
