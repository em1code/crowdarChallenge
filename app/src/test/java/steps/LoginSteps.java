package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

    LoginPage login = new LoginPage();
    HomePage home = new HomePage();

    // Background
    @Given("I am on the login page")
    public void navigateToLoginPage() {
        login.navigateToLoginPage();
    }

    @Then("I see the title Swag Labs")
    public void validateTheTitle() {
        Assert.assertEquals("Swag Labs", login.getTextFromTitle());
    }

    // Scenario Valid user
    @When("I enter the username standard_user and the password secret_sauce")
    public void enterValidUsernameAndPassword() {
        login.completeUsernameField("standard_user");
        login.completePasswordField("secret_sauce");
    }

    @And("^I click the login button$")
    public void clickOnLoginButton() {
        login.clickOnLoginButton();
    }

    @Then("I should see the products page correctly")
    public void verifyProductPageIsCorrect() {
        Assert.assertFalse(home.validateProductItemsPage());
    }

    // Scenario locked user
    @When("I enter the username locked_out_user and the password secret_sauce")
    public void enterLockedUsernameAndPassword() {
        login.completeUsernameField("locked_out_user");
        login.completePasswordField("secret_sauce");
    }

    @Then("^I should see an error message indicating that there has been a problem with the login$")
    public void verifyLockedErrorMessage() {
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", login.validateErrorMessage());
    }

    // Scenario: Invalid login with problematic user
    @When("^I enter the username problem_user and the password secret_sauce$")
    public void enterProblematicUser() {
        login.completeUsernameField("problem_user");
        login.completePasswordField("secret_sauce");
    }

    @Then("^I should see the products page with wrong images$")
    public void verifyProductPageIsNotCorrect() {
        Assert.assertTrue(home.validateProductItemsPage());
    }

    // Scenario: Login with performance glitch user
    @When("^I enter the username performance_glitch_user and the password secret_sauce$")
    public void enterPerformanceGlitchUser() {
        login.completeUsernameField("performance_glitch_user");
        login.completePasswordField("secret_sauce");
    }

    @Then("^I should see a delay loading the products page$")
    public void verifyPerformanceDelayLoadingPage() {
        Assert.assertNotEquals( 1, login.getPageLoadTime(), 6);
        Assert.assertFalse(home.validateProductItemsPage());
    }

    // Scenario: Login without entering username and password
    @When("^I do not enter any username and password$")
    public void doNotEnterAnyUsernameAndPassword(){
            
    }
    
    @Then("^I should see an error message indicating that username and password are required$")
    public void verifyRequiredUsernameAndPasswordMessage(){
        Assert.assertEquals("Expected message is not correct", "Epic sadface:  is required", login.validateErrorMessage());
    }

    // Scenario Outline: Login with valid username and invalid password
    // Scenario Outline: Login with valid username and invalid password
    @When("^I enter the user (.+) and password (.+)$")
    public void enterUsernameAndPassword(String username, String password){
        login.completeUsernameField(username);
        login.completePasswordField(password);
    }

    @Then("^I should see an error message indicating that the username/password is not correct$")
    public void verifyMissingPasswordMessage(){
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", login.validateErrorMessage());
    }


}
