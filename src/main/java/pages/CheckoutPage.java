package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class CheckoutPage extends SeleniumWrappers{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="place_order") 
	public WebElement placeOrderButton;
	
	@FindBy(css="span[class='woocommerce-terms-and-conditions-checkbox-text']") 
	public WebElement terms;
	
	@FindBy(xpath="//*[contains(text(), 'Thank you')]") 
	public WebElement orderMessage;
	
	@FindBy(xpath="//*[contains(text(), 'Order number')]") 
	public WebElement orderNumber;
	
	public void placeOrder() {
		Actions action = new Actions(driver);
		action.scrollToElement(terms).perform();
		click(terms);
		click(placeOrderButton);
	}
	
	public String getOrderMessage() {
		waitForElementToBeVisible(orderMessage);
		System.out.println(orderMessage.getText());
		return orderMessage.getText();
	}
	
	public String getOrderNumber() {
		waitForElementToBeVisible(orderNumber);
		System.out.println(orderNumber.getText());
		return orderNumber.getText();
	}
	
}