package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefinition {

    @Given("^User is on Netbanking landing page after login$")
    public void user_is_on_netbanking_landing_page_after_login() throws Throwable {
       // throw new PendingException();
        System.out.println("Net banking home page after login");
    }

    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
        //throw new PendingException();
    	System.out.println("User login into application with username and password");
    }

    @Then("^User is taken to the home page$")
    public void user_is_taken_to_the_home_page() throws Throwable {
       // throw new PendingException();
    	System.out.println("User is taken to the home page");
    }

    @And("^Cards are displayed$")
    public void cards_are_displayed() throws Throwable {
        //throw new PendingException();
    	System.out.println("Cards are displayed");
    }

}