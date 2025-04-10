package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
	public String landingPageProductName;
	public String offerPageProductName;
	public LandingPage landingPage;
	TestContextSetup testContextSetup;

	public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("Verify that user is on greenkart website")
	public void verify_that_user_is_on_greenkart_website() {
		
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
		

	}

	@When("^User searched with short name (.+) and extract actual name of the product$")
	public void user_searched_with_short_name_and_extract_actual_name_of_the_product(String shortName)
			throws InterruptedException {

		
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		// testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " = extracted from the home page");

	}
	
	@When("Added {string} items of the selected product to cart")
	public void added_items_product(String quantity) {
		
		landingPage.increaseQuantity(Integer.parseInt(quantity));
		landingPage.addToCartBtn();
	}

}
