package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;

public class ApiTestSteps {

    private RequestSpecification request;
    private Response response;

    // Scenario: As a user I want to verify that Departaments section in
    // Mercadolibre API
    @Given("^I perform GET to the endpoint$")
    public void performGETOperation() {
        request = given().log().all().param("", "");
    }

    @Then("^I should see the section (.+)")
    public void verifyDepartmentsSection(String expectedResponse) {
        response = request.when().get("https://www.mercadolibre.com.ar/menu/departments");
        response.then().statusCode(200);
        response.then().assertThat().body(Matchers.containsString(expectedResponse));
    }

}
