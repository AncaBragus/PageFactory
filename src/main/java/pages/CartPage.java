package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class CartPage extends SeleniumWrappers{

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="div[class='wc-proceed-to-checkout']") 
	public WebElement checkoutButton;
	
	@FindBy(css="tr[class='woocommerce-cart-form__cart-item cart_item']") 
	public List<WebElement> cartProducts;
	
	@FindBy(css="td>strong>span[class='woocommerce-Price-amount amount']") 
	public WebElement cartTotal;
	
	@FindBy(css="i[class='klbth-icon-plus']") 
	public WebElement increaseQuantity;
	
	@FindBy(css="td[class='product-price'][last()]") 
	public WebElement lastProductPrice;
	
	public void increaseQty() {
		Actions action = new Actions(driver);
		action.scrollToElement(increaseQuantity).perform();
		click(increaseQuantity);
		waitForElementToBeVisible(cartTotal);
	}
	
	public String getTotalPrice() {
		String totalPrice = cartTotal.getText();
		return totalPrice;
	}
	
	public void checkoutOrder() {
		waitForElementToBeVisible(checkoutButton);
		click(checkoutButton);
	}
	
}
