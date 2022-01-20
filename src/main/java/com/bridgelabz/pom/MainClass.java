package com.bridgelabz.pom;

import java.util.Iterator;
import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.google.j2objc.annotations.Property;

public class MainClass {

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\OneDrive\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Logger log = Logger.getLogger(MainClass.class);
		PropertyConfigurator.configure(
				"C:\\Users\\asus\\eclipse-workspace\\BookSwagonStore\\src\\main\\java\\com\\seleniumlogs\\Log4j.properties");
		driver.get("https://www.bookswagon.com/login");
		log.debug("Open Website");
		driver.manage().window().maximize();
		log.info("Maximize the window");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.insertEmail("meghnaborkar23@gmail.com");
		log.info("Email has been entered");
		loginpage.insertPassword("9158921359");
		log.info("Entering the password");
		loginpage.clickLoginBtn();
		log.info("Clicking on the login button");
		
		
		HomePage homepage = new HomePage(driver);
		homepage.books();
//		homepage.Logo();
//		homepage.newArrivals();
//		homepage.insertintoSearchBar();
//		homepage.clickonSearchButton();
//		AddToCart addtocart = new AddToCart(driver);
//		addtocart.openCart();
//		addtocart.adddToWishList();
//		addtocart.shoppingCart();
//		

		
	

	}

}
