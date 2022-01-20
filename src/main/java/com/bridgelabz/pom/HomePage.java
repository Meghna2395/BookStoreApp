package com.bridgelabz.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	private String HomeURL = "https://www.bookswagon.com/";

	private String UserURL = "https://www.bookswagon.com/myaccount.aspx";

	private String ArrivalURL = "https://www.bookswagon.com/view-books/0/new-arrivals";

	private String PreOrderURL = "https://www.bookswagon.com/view-books/3/coming-soon-pre-order-now";

	private String BestSellerURL = "https://www.bookswagon.com/view-books/1/top-selling-books";

	private String TextBookURL = "https://www.bookswagon.com/view-books/4/textbook";

	private String AwardwinnersURL = "https://www.bookswagon.com/view-books/5/award-winners";

	private String FeaturedauthorsURL = "https://www.bookswagon.com/featured-authors";

	private String SearchedResultURL = "https://www.bookswagon.com/search-books/three-minutes-for-dog";

	@FindBy(id = "ctl00_TopSearch1_txtSearch")
	WebElement SearchBar;
	@FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
	WebElement SearchButton;
	@FindBy(linkText = "Books")
	WebElement Books;

	@FindBy(xpath = "//body[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]")
	WebElement ListBooks;

	@FindBy(tagName = "img")
	WebElement Logo;

	@FindBy(linkText = "New Arrivals")
	WebElement NewArrivals;

	@FindBy(linkText = "Pre-order")
	WebElement PreOrder;

	@FindBy(linkText = "Bestsellers")
	WebElement BestSellers;

	@FindBy(linkText = "TextBooks")
	WebElement textbooks;

	@FindBy(linkText = "Award Winners")
	WebElement AwardWinners;

	@FindBy(linkText = "Featured Authors")
	WebElement FeaturedAuthors;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openingHomePage() {
		driver.get(HomeURL);
	}

	public void SearchBar(String nameOfBook) {
		SearchBar.sendKeys(nameOfBook);
	}

	public void clickonSearchButton() {
		SearchButton.click();

	}

	public void books() {
		Books.click();

	}

	public void Logo() {
		Logo.click();

	}

	public void newArrivals() {
		NewArrivals.click();
	}

	public void preOrder() {
		PreOrder.click();
	}

	public void bestSellers() {
		BestSellers.click();
	}

	public void textBooks() {
		textbooks.click();
	}

	public void awardWinners() {
		AwardWinners.click();
	}

	public void featuredAuthors() {
		FeaturedAuthors.click();
	}

	public String getArrivalURL() {
		return ArrivalURL;
	}

	public String getBestSellerURL() {
		return BestSellerURL;
	}

	public String getUserURL() {
		return UserURL;
	}

	public WebElement gettextbooks() {
		return textbooks;
	}

	public String getPreOrderURL() {
		return PreOrderURL;
	}

	public String getTextBookURL() {
		return TextBookURL;
	}

	public String getAwardwinnersURL() {
		return AwardwinnersURL;
	}

	public String getFeaturedauthorsURL() {
		return FeaturedauthorsURL;
	}

	public WebElement getBestSellers() {
		return BestSellers;
	}

	public WebElement getAwardWinners() {
		return AwardWinners;
	}

	public String getHomeURL() {
		return HomeURL;
	}

	public String getSearchedResultURL() {
		return SearchedResultURL;
	}

}
