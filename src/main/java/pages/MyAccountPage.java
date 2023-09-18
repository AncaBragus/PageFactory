package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class MyAccountPage extends SeleniumWrappers{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username") 
	public WebElement usernameField;

	@FindBy(id="password")
	public WebElement passwordField;

	@FindBy(name="login")
	public WebElement signInButton;

	@FindBy(css="div[class='woocommerce-MyAccount-content']")
	public WebElement greetingsMessage;
	
	@FindBy(linkText = "Log out")
	public WebElement logOutButton;

	@FindBy(id="dgwt-wcas-search-input-1")
	public WebElement searchForInput;

	@FindBy(css="span[class='dgwt-wcas-st-title']")
	public WebElement foundProduct;
	
	@FindBy(css="i[class='klbth-icon-shopping-bag']") 
	public WebElement shoppingBag;
	
	public void loginInApp(String user, String pass) {
		sendKeys(usernameField, user);
		sendKeys(passwordField, pass);
		click(signInButton);
	}
	public void searchForProducts(String product) {
		sendKeys(searchForInput, product);
		click(searchForInput);
		waitForElementToBeVisible(foundProduct);
		click(foundProduct);
	}

	public void openShoppingBag() {
		waitForElementToBeVisible(shoppingBag);
		click(shoppingBag);
	}
}
