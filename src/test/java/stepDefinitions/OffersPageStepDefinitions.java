package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {
	PageObjectManager pageObjectManager;
	public String offerPageProductName = null;
	TestContextSetup testContextSetup;

	public OffersPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	public void switchToOffersPage() {

		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.clickTopDeals();
		testContextSetup.genericUtils.switchWindowToChild();
		
	}

	@Then("^User go and search for the (.+) shortname in offers page$")
	public void user_go_and_search_for_the_sameshort_name_in_offers_page(String shortName) throws InterruptedException {

		switchToOffersPage();
		OffersPage offerPage = testContextSetup.pageObjectManager.getOffersPage();
		offerPage.searchItem(shortName);
		offerPageProductName = offerPage.getProductName();
		Thread.sleep(2000);

	}

	@Then("Validate product name in offers page matches with Landing Page")
	public void validateTheProduct() {

		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}

}
