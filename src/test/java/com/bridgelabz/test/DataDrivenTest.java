package com.bridgelabz.test;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.experimental.theories.DataPoint;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest extends Base {

	@Test(dataProvider = "LoginData")
	public void loginTest(String email, String Password, String exp) {
		driver.get("https://www.bookswagon.com/login");

		WebElement txtEmail = driver.findElement(By.xpath("//*[@name='ctl00$phBody$SignIn$txtEmail']"));
		txtEmail.sendKeys(email);

		WebElement txtPassword = driver.findElement(By.id("ctl00_phBody_SignIn_txtPassword"));
		txtPassword.sendKeys(Password);
		driver.findElement(By.name("ctl00$phBody$SignIn$btnLogin")).click();

		String exp_title = "https://www.bookswagon.com/myaccount.aspx";
		String actualTitle = driver.getTitle();

		if (exp.equals("valid")) {
			if (exp_title.equals(actualTitle)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

	}

	@DataProvider(name = "LoginData") //returns a double Object class array with two sets of data
	public String[][] getData() throws IOException {
		String path = "C:\\Users\\asus\\eclipse-workspace\\BookSwagonStore\\ExcelData\\loginSheet.xlsx";

		Utility excelUtils = new Utility(path);
		int totalrows = excelUtils.getRowCount("Sheet1");
		int totalcols = excelUtils.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalrows][totalcols];
		for (int i = 1; i < totalrows; i++) { // 1
			for (int j = 0; j < totalcols; j++) { // 0
				loginData[i - 1][j] = excelUtils.getCellData("Sheet1", i, j);
			}
		}
		return loginData;

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
