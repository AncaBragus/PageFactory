package pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import utils.SeleniumWrappers;

	public class ProductPage extends SeleniumWrappers{

		public ProductPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}

		@FindBy(name="add-to-cart") 
		public WebElement addToCartButton;
		
		@FindBy(css="div[class='woocommerce-message']") 
		public WebElement addToCartMessage;
		
		public void addToCart() {
			click(addToCartButton);
			waitForElementToBeVisible(addToCartMessage);
		}
		
}