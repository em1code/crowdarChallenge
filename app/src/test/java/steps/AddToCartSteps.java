package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class AddToCartSteps {

    LoginPage login = new LoginPage();
    HomePage home = new HomePage();
    CartPage cart = new CartPage();

    // Scenario Outline: Add multiple products to the cart
    @Given("^I add the product (.+) to the shopping cart$")
    public void addProductToShoppingCart(String product){
        home.addItemToCart(product);
    }

    @And("^I should see the shopping cart icon with a quantity of (.+)$")
    public void verifyShoppingCartIcon(String quantity){
        Assert.assertEquals(quantity, home.getShoppingCartBudget());
    }

    @When("^I click on shopping cart icon$")
    public void clickOnCartIcon(){
        home.clickOnCartIcon();
    }
    
    @Then("^the shopping cart displays the product (.+)$")
    public void verifyProductIsAddedToCart(String product){
        Assert.assertTrue(cart.itemIsOnCart(product));
    }

    // Scenario Outline: Validate the title, description and price of the added product
    @Then("^I should see the same (.+), \"(.+)\" and (.+) that the product had before$")
    public void verifyProductIsAddedToCartCorrectly(String product, String description, String price){
        Assert.assertTrue(cart.itemIsOnCart(product));
        Assert.assertTrue(cart.verifyItemDescription(description));
        Assert.assertEquals(price, cart.getItemPrice(product));
    }

    @And("^I click on Remove (.+) button$")
    public void clickOnRemoveButton(String product){
        cart.removeItem(product);
    }
    
    @Then("^the product (.+) should be no longer displayed$")
    public void verifyProductIsRemoved(String product){
        Assert.assertFalse(cart.itemIsOnCart(product));
    }
}
