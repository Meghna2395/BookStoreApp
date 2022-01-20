package com.bridgelabz.pom;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	Actions action;
	private String MyCartURL = "https://www.bookswagon.com/shoppingcart.aspx";

	private String WishListURL = "https://www.bookswagon.com/wishlist.aspx";

	private String PlaceOrderURL = "https://www.bookswagon.com/checkout-login";

	private String ShippingURL = "https://www.bookswagon.com/shippingoption.aspx";

	@FindBy(className = "btn-black")
	WebElement AddToWishList;
	@FindBy(xpath = "//span[@class='cart-item-count']")
	WebElement MyCart;
	@FindBy(className = "empty-shopping-cart")
	WebElement EmptyCart;
	@FindBy(xpath = "//div[@id='colorbox']")
	WebElement CartPopUP;
	@FindBy(xpath = "//div[@id='cboxClose']")
	WebElement CloseCart;
	@FindBy(xpath = "//input[@id='BookCart_lvCart_imgPayment']")
	WebElement PlaceOrderBTN;
	@FindBy(xpath = "//h1[contains(text(),'My Shopping Cart')]")
	WebElement CartTitle;
	@FindBy(xpath = "//a[contains(text(),'Remove') and @xpath='2']")
	WebElement Remove;
	@FindBy(xpath = "//input[@value='Buy Now']")
	WebElement BuyNowBTN;
	By CartItem = By.xpath("//div[@class = 'shopping-content']");
	@FindBy(name = "ctl00$phBody$WishList$lvWishList$ctrl0$ImageButton1")
	WebElement RemoveFromCart;

	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	WebElement ContinueButton;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void visitMyCart() {
		driver.get(MyCartURL);
	}

	public boolean isCartOpen() {
		return CartTitle.isDisplayed();
	}

	public void removeItemsFromCart() {
		Remove.click();

	}

	public boolean isCartEmpty() {
		return EmptyCart.isDisplayed();

	}

	public void removeFromCart() {
		RemoveFromCart.click();
	}

	public void addToWishList() {
		AddToWishList.click();
	}

	public String getMyCartURL() {
		return MyCartURL;
	}

	public void placeOrder() {
		PlaceOrderBTN.click();
	}

	public void continueButton() {
		ContinueButton.click();
	}

	public String getPlaceOrderURL() {
		return PlaceOrderURL;
	}

	public String getWishListURL() {
		return WishListURL;
	}

	public String getShippingURL() {
		return ShippingURL;
	}

}
