package com.bridgelabz.test;

import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bridgelabz.pom.AddToCart;
import com.bridgelabz.pom.CartPage;
import com.bridgelabz.pom.HomePage;
import com.bridgelabz.pom.LoginPage;
import com.bridgelabz.pom.MyAccount;

public class BookSwagonTestForPositiveScenario extends Base {

	@Test(priority = 0)
	public void validCredentials() {
		ExtentTest test = extent.createTest("Login with Valid Credentials");
		loginpage.openingLoginPage();
		test.log(Status.INFO, "Launching Login Page");
		loginpage.insertEmail("meghnaborkar23@gmail.com");
		test.pass("Entered the email");
		loginpage.insertPassword("9158921359");
		test.pass("Entered the password");
		loginpage.clickLoginBtn();
		test.log(Status.INFO, "Clicking on the Login Button");
		String actualPageURL = driver.getCurrentUrl();
		Assert.assertEquals(actualPageURL, loginpage.getUser_URL());
		test.pass("Logged in Successfully");
		extent.flush();
	}

	@Test(priority = 1)
	public void verifyLogo() {
		loginpage.getUser_URL();
		WebElement Logo = driver.findElement(By.tagName("img"));
		Assert.assertEquals(true, Logo.isDisplayed());
	}

	@Test(priority = 2)
	public void personalSettingPage() {
		myaccount.personalSettings();
		Assert.assertEquals(driver.getCurrentUrl(), myaccount.getAccountSettingsURL());
	}

	@Test(priority = 3)
	public void myOrdersPage() {
		myaccount.myOrders();
		Assert.assertEquals(driver.getCurrentUrl(), myaccount.getMyOrdersURL());
	}

	@Test(priority = 4)
	public void myWishListPage() {
		myaccount.myWishlist();
		Assert.assertEquals(driver.getCurrentUrl(), myaccount.getMyWishListURL());
	}

	@Test(priority = 5)
	public void myAddressesPage() {
		myaccount.myAddresses();
		Assert.assertEquals(driver.getCurrentUrl(), myaccount.getMyAddressesURL());
	}

	@Test(priority = 6)
	public void addNewAddressBTN() {
		myaccount.myAddresses();
		myaccount.addNewAddress();

	}

	@Test(priority = 7)
	public void verifyChangePassword() {
		myaccount.changePassword();
		// Assert.assertEquals(driver.getCurrentUrl(),
		// myaccount.getChangePasswordURL());
		driver.navigate().to("https://www.bookswagon.com/");
	}

	@Test(priority = 8)
	public void newArrivalPage() {

		homepage.openingHomePage();
		homepage.newArrivals();
		String actualPageURL = driver.getCurrentUrl();
		Assert.assertEquals(actualPageURL, homepage.getArrivalURL());

	}

	@Test(priority = 9)
	public void preOrderPage() {

		homepage.openingHomePage();
		homepage.preOrder();
		String actualPageURL = driver.getCurrentUrl();
		Assert.assertEquals(actualPageURL, homepage.getPreOrderURL());

	}

	@Test(priority = 10)
	public void textBookPage() {

		homepage.openingHomePage();
		homepage.textBooks();
		String actualPageURL = driver.getCurrentUrl();
		Assert.assertEquals(actualPageURL, homepage.getTextBookURL());

	}

	@Test(priority = 11)
	public void awardWinnerPage() {

		homepage.openingHomePage();
		homepage.awardWinners();
		String actualPageURL = driver.getCurrentUrl();
		Assert.assertEquals(actualPageURL, homepage.getAwardwinnersURL());

	}

	@Test(priority = 12)
	public void featuredAuthorsPage() {

		homepage.openingHomePage();
		homepage.featuredAuthors();
		String actualPageURL = driver.getCurrentUrl();
		Assert.assertEquals(actualPageURL, homepage.getFeaturedauthorsURL());

	}

	@Test(priority = 13)
	public void bestSellerPage() {

		homepage.openingHomePage();
		homepage.bestSellers();
		String actualPageURL = driver.getCurrentUrl();
		Assert.assertEquals(actualPageURL, homepage.getBestSellerURL());

	}

//	@Test(priority = 15)
//	public void visitToMyCart() {
//		homepage.openingHomePage();
//		cartpage.visitMyCart();
//		assertTrue(cartpage.isCartOpen());
//	}

	// @Test(priority = 14)
//	public void verifyIsCartEmpty() {
//		homepage.openingHomePage();
//		cartpage.visitMyCart();
//		Assert.assertEquals(cartpage.isCartEmpty(), true);
//	}

//	@Test(priority = 15)
//	public void visitToMyShoppingCart() {
//		cartpage.visitMyCart();
//		assertEquals(driver.getCurrentUrl(), cartpage.getMyCartURL());
//		
//	}

	@Test(priority = 16)
	public void searchListofBooks() {
		homepage.openingHomePage();
		homepage.SearchBar("chetan bhagat");
		homepage.clickonSearchButton();
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='cover']"));
		System.out.println("Size of webelements: " + searchResults.size());
		searchResults.get(3).click();
	}

	@Test(priority = 17)
	public void toSearchBook() {
		homepage.SearchBar("Three minutes for dog");
		homepage.clickonSearchButton();
		Assert.assertEquals(driver.getCurrentUrl(), homepage.getSearchedResultURL());
	}

	@Test(priority = 18)
	public void addItemToCart() {
		homepage.SearchBar("Three minutes for dog");
		homepage.clickonSearchButton();
		cartpage.addToWishList();
		Assert.assertEquals(driver.getCurrentUrl(), cartpage.getWishListURL());
	}

	@Test(priority = 19)
	public void removeItemFromCart() {

		homepage.SearchBar("Three minutes for dog");
		homepage.clickonSearchButton();
		cartpage.addToWishList();
		cartpage.removeFromCart();
		Assert.assertEquals(driver.getCurrentUrl(), cartpage.getWishListURL());

	}

	@Test(priority = 20)
	public void placeOrder() {

		cartpage.visitMyCart();
		cartpage.placeOrder();

	}

	@Test(priority = 21)
	public void logoutAction() {
		homepage.openingHomePage();
		loginpage.logoutOption();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
