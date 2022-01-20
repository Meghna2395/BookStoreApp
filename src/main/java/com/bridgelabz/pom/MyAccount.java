package com.bridgelabz.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.errorprone.annotations.FormatMethod;

public class MyAccount {
	WebDriver driver;

	private String LoginURL = "https://www.bookswagon.com/login";

	private String UserURL = "https://www.bookswagon.com/myaccount.aspx";

	private String AccountURL = "https://www.bookswagon.com/myaccount.aspx";

	private String AccountSettingsURL = "https://www.bookswagon.com/accountsetting.aspx";

	private String MyOrdersURL = "https://www.bookswagon.com/orders.aspx";

	private String MyWishListURL = "https://www.bookswagon.com/wishlist.aspx";

	private String MyAddressesURL = "https://www.bookswagon.com/myaddress.aspx";

	private String ChangePasswordURL = "https://www.bookswagon.com/changepassword.aspx";

	@FindBy(linkText = "Personal Settings")
	WebElement PersonalSetting;
	@FindBy(name = "ctl00$phBody$AccountSetting$fvCustomer$imgUpdate")
	WebElement Edit;
	@FindBy(linkText = "My Orders")
	WebElement MyOrders;
	@FindBy(linkText = "My Wishlist")
	WebElement WishList;
	@FindBy(linkText = "My Addresses")
	WebElement MyAddress;
	@FindBy(linkText = "Change Password")
	WebElement ChangePassword;
	@FindBy(linkText = "My Gift Certificate")
	WebElement Certificate;
	@FindBy(xpath = "//tbody/tr[1]/td[2]/a[1]")
	WebElement AddNewAddress;
	@FindBy(name = "ctl00$phBody$ChangePassword$txtCurPwd")
	WebElement CurrentPassword;
	@FindBy(name = "ctl00$phBody$ChangePassword$txtNewPassword")
	WebElement NewPassword;
	@FindBy(name = "ctl00$phBody$ChangePassword$txtConfirmPwd")
	WebElement Confirmpassword;
	@FindBy(name = "ctl00$phBody$ChangePassword$imgSubmit")
	WebElement ChangePasswortButton;

	public MyAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void personalSettings() {
		PersonalSetting.click();
		Edit.click();

	}

	public void myOrders() {
		MyOrders.click();
	}

	public void myWishlist() {
		WishList.click();
	}

	public void myAddresses() {
		MyAddress.click();
	}

	public void addNewAddress() {
		AddNewAddress.click();
	}

	public void changePassword() {
		ChangePassword.click();
	}

	public void insertCurrentPassword(String currentPassword) {
		CurrentPassword.sendKeys(currentPassword);
	}

	public void insertNewPassword(String NewPassword) {
		CurrentPassword.sendKeys(NewPassword);
	}

	public void confirmPassword(String ConfirmPassword) {
		Confirmpassword.sendKeys(ConfirmPassword);
	}

	public void changePasswordBTN() {
		ChangePasswortButton.click();
	}

	public void myGiftCertificate() {
		Certificate.click();
	}

	public void editButton() {
		Edit.click();
	}

	public String getAccountURL() {
		return AccountURL;
	}

	public String getAccountSettingsURL() {
		return AccountSettingsURL;
	}

	public String getMyOrdersURL() {
		return MyOrdersURL;
	}

	public String getMyWishListURL() {
		return MyWishListURL;
	}

	public String getMyAddressesURL() {
		return MyAddressesURL;
	}

	public String getChangePasswordURL() {
		return ChangePasswordURL;
	}

}
