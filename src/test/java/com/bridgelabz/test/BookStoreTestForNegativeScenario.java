package com.bridgelabz.test;

import static org.junit.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class BookStoreTestForNegativeScenario extends Base {
	
	@Test
	public void invalidCredentials() {
		ExtentTest test = extent.createTest("Login with Invalid Credentials");
		loginpage.openingLoginPage();
		loginpage.insertEmail("meghna@gmail.com");
		loginpage.insertPassword("123456666");
		loginpage.clickLoginBtn();
		String actualPageURL = driver.getCurrentUrl();
		Assert.assertNotEquals(actualPageURL, loginpage.getUser_URL());
		extent.createTest("Invalid credentials").fail("Log in Failed");
	}
	
	

}
