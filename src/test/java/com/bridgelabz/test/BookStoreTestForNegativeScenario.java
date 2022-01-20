package com.bridgelabz.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreTestForNegativeScenario extends Base {
	
	@Test
	public void invalidCredentials() {
		loginpage.openingLoginPage();
		loginpage.insertEmail("meghna@gmail.com");
		loginpage.insertPassword("123456666");
		loginpage.clickLoginBtn();
		String actualPageURL = driver.getCurrentUrl();
		Assert.assertNotEquals(actualPageURL, loginpage.getUser_URL());
	}

}
