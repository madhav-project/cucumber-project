package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {
	public String landingPageProductName;
	public String offerPageProductName;
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;

	public CheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.checkoutPage();
	}
	
	@Then("Verify user has ability to enter promocode and place the order")
	public void Verify_user_has_ability_to_enter_promocode_and_place_the_order() {
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderBtn());
	}
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void Verify_user_has_ability_to_enter_promocode_and_place_the_order(String name) throws InterruptedException {
		checkoutPage.checkOutItems();
	}
	

}
