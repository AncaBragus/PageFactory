package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import utils.BaseTest;
import pages.ProductPage;
import pages.CartPage;
import pages. CheckoutPage;
public class PlaceOrderTest extends BaseTest {
	/*
	 * Login in app
	 * search product from homepage
	 * find and navigate to product
	 * add product to basket
	 * search another product
	 * find and navigate to product
	 * add product to basket
	 * go cart page
	 * place order
*/
	@Test
	public void placeOrder() throws InterruptedException {
		
		ProductPage product = new ProductPage (driver);
		CartPage cart = new CartPage (driver);
		CheckoutPage order = new CheckoutPage (driver);
		
		app.click(app.menu.myAccountLink);
		app.myAccount.loginInApp("customer", "customer@123");
		assertTrue(app.checkElementIsDisplayed(app.myAccount.greetingsMessage));
		
		app.myAccount.searchForProducts("Pretzel");		
		product.addToCart();
		
		app.myAccount.searchForProducts("Ice Cream");
		product.addToCart();
				
		app.myAccount.openShoppingBag();
		
		String initialPrice = cart.getTotalPrice();
		cart.increaseQty();
		Thread.sleep(2000);
		String updatedPrice = cart.getTotalPrice();
		Thread.sleep(2000);
		assertTrue(initialPrice!=updatedPrice);
		
		cart.checkoutOrder();
		Thread.sleep(2000);
		
		order.placeOrder();
		Thread.sleep(2000);
		
		assertTrue((order.getOrderMessage()).contains("Thank you. Your order has been received."));
		assertTrue((order.getOrderNumber()).contains("Order number:"));
		Thread.sleep(2000);
	}
	
	
}
