package com.bridgelabz.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	Actions action;

	private String LoginURL = "https://www.bookswagon.com/login";

	private String UserURL = "https://www.bookswagon.com/myaccount.aspx";

	private String URL = "https://www.bookswagon.com/";

	@FindBy(id = "ctl00_phBody_SignIn_txtEmail")
	WebElement Email;
	@FindBy(id = "ctl00_phBody_SignIn_txtPassword")
	WebElement Password;
	@FindBy(name = "ctl00$phBody$SignIn$btnLogin")
	WebElement LoginButton;
	@FindBy(xpath = "//a[@id = 'ctl00_lnkbtnLogout']")
	WebElement LogoutButton;
	@FindBy(xpath = "//span[@id = 'ctl00_lblUser']")
	WebElement UserButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}

	public void openingLoginPage() {
		driver.get(LoginURL);
	}

	public String getLoginURL() {
		return LoginURL;
	}

	public String getUser_URL() {
		return UserURL;
	}

	public void insertEmail(String email) {

		Email.sendKeys(email);

	}

	public void insertPassword(String password) {

		Password.sendKeys(password);
	}

	public void clickLoginBtn() {

		LoginButton.click();

	}

	public void logoutOption() {
		action.moveToElement(UserButton).click(LogoutButton).perform();
	}

	public String getURL() {
		return URL;
	}

}
