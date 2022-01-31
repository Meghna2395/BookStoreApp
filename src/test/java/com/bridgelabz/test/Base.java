package com.bridgelabz.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bridgelabz.pom.CartPage;
import com.bridgelabz.pom.HomePage;
import com.bridgelabz.pom.LoginPage;
import com.bridgelabz.pom.MyAccount;

public class Base {
	
	ExtentReports extent;
	
	ExtentSparkReporter extentSparkReporter;

	WebDriver driver;

	LoginPage loginpage;

	HomePage homepage;

	CartPage cartpage;

	MyAccount myaccount;

	@BeforeTest
	public void testSetup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\OneDrive\\Desktop\\chromedriver.exe");
		
		extent = new ExtentReports();
		
		extentSparkReporter = new ExtentSparkReporter("extentReport.html");
		
		extent.attachReporter(extentSparkReporter);
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setDocumentTitle("Report for BookSwaganStore");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		loginpage = new LoginPage(driver);

		homepage = new HomePage(driver);

		cartpage = new CartPage(driver);

		myaccount = new MyAccount(driver);
	}

}
