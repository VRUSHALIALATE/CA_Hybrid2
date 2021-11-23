package com.mindtree.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.utility.RetreiveExcelData;
import com.mindtree.pageObjects.AboutUsPage;
import com.mindtree.pageObjects.AllOfItPage;
import com.mindtree.pageObjects.ChristmasGiftPage;
import com.mindtree.pageObjects.ContactUsPage;
import com.mindtree.pageObjects.GitCardPage;
import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.PersonalizedGiftPage;
import com.mindtree.pageObjects.SearchBoxPage;
import com.mindtree.pageObjects.ShopByCatagoryPage;
import com.mindtree.pageObjects.SignInPage;
import com.mindtree.pageObjects.WishListPage;
import com.mindtree.reusableComponent.WebDriverHelper;
import com.mindtree.utility.ReadPropertyFile;

public class BigSmall {

	Logger log = LogManager.getLogger(BigSmall.class.getName());

	WebDriver driver = null;
	ReadPropertyFile rp = null;

	/*
	 * this method is responsible for landing at home page and click on sign button.
	 * 
	 * WebDriverHelper class has a initializeDriver() method which will launch and
	 * initialize the driver.
	 * 
	 * ReadPropertyFile class :- contains method which is used to retrieve data from
	 * property file.
	 * 
	 * HomePage class contains method to return webelement of respective web page;
	 */

	@Test(priority = 1)
	public void homePageLanding() throws Exception {

		rp = new ReadPropertyFile();
		log.info("browser is going to launch");
		WebDriverHelper.launchingBrowser();
		log.info("Browser has been luanched");

		driver = WebDriverHelper.getDriver();

		driver.get(rp.getUrl());
		log.info("url hited");

	}

	/*
	 * this method is responsible for sending username and password to login form.
	 * 
	 * ReadPropertyFile class :- contains method which is used to retrieve data from
	 * property file.
	 * 
	 * SignInPage class contains method to return webelement of after after sign
	 * page;
	 * 
	 * Data provider attribute is being used to call datasuplier method to return
	 * data combination one by one.
	 */
	@Test(priority = 2, dataProvider = "dataSuplier")
	public void signInTesting(String username, String password) throws Exception {

		HomePage hp = new HomePage(driver);

		hp.getSignIn().click();
		log.info("clicked on sign button");

		SignInPage sp = new SignInPage(driver);

		sp.getEmail().clear();
		sp.getEmail().sendKeys(username);
		log.info(username + " entered");
		sp.getPassword().clear();
		sp.getPassword().sendKeys(password);
		log.info(password + " entered");
		sp.getSignInSmmitButton().click();
		log.info("clicked on summit button");

//		if(sp.getErrorMessageTitle()!=null && sp.getErrorMessageTitle().getText().equalsIgnoreCase("Incorrect email or password.")) {		Assert.assertTrue(true);
//		log.info("Wrong credentials");
//		}
//	    if else(sp.get)
//	    { 
//		  Assert.assertTrue(false); 
//		  log.info("Wrong Credantials Found");
//		}	
	}

	@Test(priority = 3)
	public void persionalizedGiftMenuTesting() throws InterruptedException {
		PersonalizedGiftPage pg = new PersonalizedGiftPage(driver);

		Thread.sleep(5000L);

		pg.getPersionaizedGiftMenu().click();
		log.info("clicked on Persionaized Gift Menu");

		Thread.sleep(5000L);
		pg.getSortBy().click();

		pg.getDropDownOption().click();
		pg.getGetFirstItem().click();

		Thread.sleep(5000L);

		if (pg.getAddToCard().getText().equalsIgnoreCase("add to cart")) {
			Assert.assertTrue(true);
			log.info("persionalized gift menu's item selected");
		} else {
			Assert.assertTrue(false);
			log.info("persionalized gift menu's item not selected");
		}
	}

	@Test(priority = 4)
	public void searchingBoxTesting() throws IOException, InterruptedException {

		SearchBoxPage sb = new SearchBoxPage(driver);

		List<String> list = RetreiveExcelData.getData("searchProduct");

		Thread.sleep(5000);
		log.info(list.get(1));
		sb.getSearchBox().sendKeys(list.get(1));
		sb.getSearchBox().sendKeys(Keys.ENTER);
		log.info("product name has been sent to search box");

		if (sb.getProductList().size() > 0) {
			Assert.assertTrue(true);
			log.info("list appeared of searched product");
		} else {
			Assert.assertTrue(false);
			log.info("list not appeared of searched product");
		}

	}

	@Test(priority = 5)
	public void ChristmasGiftMenuTesting() throws InterruptedException {
		ChristmasGiftPage cp = new ChristmasGiftPage(driver);

		cp.getChristmas().click();
		log.info("clicked on christmas menu");

		List<WebElement> list = cp.getProductList();
		list.get(0).click();

		cp.getAddToCart().click();
		log.info("christmas gift added in cart");

		Thread.sleep(5000);
//
//		 if(cp.getPop().isDisplayed()) 
//		 { log.info("pop up appeared");  }
//		else { 
//		 log.info("pop up not appeared"); }

		cp.getCheckOut().click();

		cp.getPop().click();
		log.info("pop up appeared");

		

		Thread.sleep(3000);
		cp.getReturnCard().click();

		Thread.sleep(3000L);
		if (cp.getShoppingCartTitle().getText().equalsIgnoreCase("shopping cart")) {
			Assert.assertTrue(true);
			log.info("christmas gift menu's item available in shopping cart");
		} else {
			Assert.assertTrue(false);
			log.info("christmas gift menu's item  available in shopping cart");
		}
	}

	@Test(priority = 6)
	public void ShopByCategoryTesting() throws InterruptedException {
		ShopByCatagoryPage sc = new ShopByCatagoryPage(driver);

		sc.getShopByCatagory().click();
		log.info("clicked on shop By catagory menu");

		List<WebElement> list2 = sc.getBirthdayCatagory();
		list2.get(1).click();

		List<WebElement> list = sc.getBirthdayProductList();
		list.get(0).click();

		sc.getAddtoWish().click();
		log.info("clicked on add to wish");

		Thread.sleep(5000);
		if (sc.getRemove().getText().equalsIgnoreCase("remove")) {
			Assert.assertTrue(true);
			log.info("item has been added in wish list");
		} else {
			Assert.assertTrue(false);
			log.info("item has not been added in wish list");
		}

	}

	@Test(priority = 7)
	public void AllOfItTesting() throws InterruptedException {
		AllOfItPage ai = new AllOfItPage(driver);

		ai.getAllOfIt().click();
		log.info("clicked on shop By all of it menu");
		ai.getProduct().click();
		if (ai.getTitle().getText().contains("Auto Rickshaw Pen Stand"))
			Assert.assertTrue(true);
		log.info("Title under All ot It is verified");

	}

	@Test(priority = 8)
	public void WishListTesting() throws InterruptedException {
		WishListPage wl = new WishListPage(driver);

		Thread.sleep(3000);
		wl.getWishList().click();
		log.info("clicked on wishlist menu");

		Thread.sleep(6000);
		if (wl.getPopup().isDisplayed())
			wl.getPopup().click();

		List<WebElement> list = wl.getProductList();

		if (list.get(0).isDisplayed()) {
			Assert.assertTrue(true);
			log.info("products are available in wish list");
		} else {
			Assert.assertTrue(false);
			log.info("products were not added in wish list");
		}
	}

	@Test(priority = 9)
	public void GitCartTesting() {
		GitCardPage gp = new GitCardPage(driver);

		gp.getGiftCard().click();
		log.info("clicked on gift card button");

		if (gp.getTitle().getText().equalsIgnoreCase("gift card")) {
			Assert.assertTrue(true);
			log.info("gift card feature is working");
		} else {
			Assert.assertTrue(false);
			log.info("gift card feature is not working");
		}
	}

	@Test(priority = 10)
	public void AboutUsTesting() {
		AboutUsPage ap = new AboutUsPage(driver);

		ap.getAboutMenu().click();
		log.info("clicked on about us menu");

		if (ap.getTitle().getText().equalsIgnoreCase("about us")) {
			Assert.assertTrue(true);
			log.info("getting all info about website");
		} else {
			Assert.assertTrue(false);
			log.info("not getting info about website");
		}

	}

	@Test(priority = 11)
	public void contactUsTesting() {
		ContactUsPage ct = new ContactUsPage(driver);

		ct.getContactUs().click();
		log.info("clicked on contact us");

		ct.getEmail().sendKeys(rp.getEmail());
		ct.getMessage().sendKeys(rp.getMessage());
		ct.getName().sendKeys(rp.getName());
		log.info("all info added");

		// ct.getSend().click();

		if (ct.getTitle().getText().equalsIgnoreCase("contact us")) {
			Assert.assertTrue(true);
			log.info("thank you for contacting us");
		} else {
			Assert.assertTrue(false);
			log.info("could not verified");
		}

	}

	
	// @AfterTest public void closeDriver() { driver.close(); driver = null; }
	

	// TO SUPPLY DATA TO LOGIN TEST METHODS.
	@DataProvider
	public Object[][] dataSuplier() {
		Object[][] usernameAndPassword = new Object[3][2];

		// FOR SIGN IN TESTING WITH EMPTY FIELD.
		usernameAndPassword[0][0] = "";
		usernameAndPassword[0][1] = "";

		// FOR SIGN IN TESTING WITH INVALID DATA.
		usernameAndPassword[1][0] = "defenceaspirants87@gmail.com";
		usernameAndPassword[1][1] = "gguytuy";

		// FOR SIGN IN TESTING WITH VALID DATA.
		usernameAndPassword[2][0] = "vrushualate1008@gmail.com";
		usernameAndPassword[2][1] = "Vrush@123";

		return usernameAndPassword;
	}

}