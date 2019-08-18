package steps;

import org.junit.Assert;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AmazonPage;

public class AmazonPageSteps {

	AmazonPage amazonPage = new AmazonPage();
	
	@Given("^I launch browser$")
	public void i_launch_browser() throws Exception {
		amazonPage.launchBrowser("Chrome", ".\\drivers");
	}

	@When("^I go to Amazon Page$")
	public void i_go_to_amazon_page() throws Exception {
		amazonPage.goToAmazonPage("https://amazon.com");
	}
	
	@When("^I search for product$")
	public void i_search_for_product() throws Exception {
		amazonPage.searchProduct("Nikon");
	}
	
	@When("^I sort results by given filter$")
	public void i_sort_results_by_given_filter() throws Exception {
		amazonPage.sortByFilter("Price: High to Low");
	}
	
	@When("^I choose model position from the top$")
	public void i_choose_model_position_from_the_top() throws Exception {
		amazonPage.chooseModelPosition(2);
	}
	
	@When("^I check model topic$")
	public void i_check_model_topic() throws Exception {
		amazonPage.getProductTopic();
	}
	
	@Then("^I verify whether topic contains expected model$")
	public void i_verify_whether_topic_contains_expected_model() throws Exception {
		boolean isFound = amazonPage.verifyIfTopicContainsModel("Nikon D3X");
		Assert.assertTrue("Expected model not found in the topic: " + amazonPage.getProductTopic(), isFound);
	}
	
    @After
    public void afterScenario() {
    	amazonPage.closeDriver();
    }
}