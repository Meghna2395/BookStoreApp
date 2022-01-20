package com.bridgelabz.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart{
	WebDriver driver;
	
	private String CartURL = "https://www.bookswagon.com/shoppingcart.aspx";
	
	@FindBy(xpath = "//tbody/tr[3]/td[1]/div[1]/a[1]/input[1]")
	WebElement BuyNow;

	@FindBy(xpath = "//body[1]/form[1]/div[4]/div[2]/div[3]/div[2]/div[1]/div[4]/div[5]/a[2]/input[1]")
	WebElement AddToWishList;
	
	@FindBy(xpath = "//body[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[5]/a[3]")
	WebElement ShoppingCart;
	
	
	public AddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openCart() {
		driver.get(CartURL);
	}
	
	public void adddToWishList() {
		AddToWishList.click();

	}
	
	public void shoppingCart() {
	ShoppingCart.click();
	}
	
	
	
	
}
