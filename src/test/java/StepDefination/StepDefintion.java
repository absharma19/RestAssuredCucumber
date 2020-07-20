package StepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.DataBuild;
import resources.Utils;

public class StepDefintion {

	//	RestAssured.baseURI=baseURL;
	RequestSpecification req;
	ResponseSpecification resspec;
	DataBuild data =new DataBuild();
	Response response;
	String adduserStatus = "Success";

	@Given("Add User Details {string} {string} {string} {string}")
	public void add_User_Payload(String name, String username, String email,String phone) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		req=given().spec(Utils.requestSpecification()).body(data.AddUserPayload(name, username, email, phone));
	}

	@When("User Call {string} with {string} HTTP Request")
	public void user_calls_with_http_request(String resource, String method) {
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec =new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
			response =req.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response =req.when().get(resourceAPI.getResource());

	}

	@Then("Verify Api Call Is success with Status code {int}")
	public void verify_Api_Call_Is_success_with_Status_code(int statusCode){
		// Write code here that turns the phrase above into concrete actions

		assertEquals(response.getStatusCode(),statusCode);
	}


	@Then("Verify field value for {string} is {string}")
	public void verify_field_value_for_is(String fieldvalue, String expectedvalue) {

		String actualvalue = Utils.getJsonPath(response,fieldvalue);
		System.out.println("Actul value from response = " +actualvalue);
		assertEquals(actualvalue, expectedvalue);
	}


	@Given("get User details where {string} is {string}")
	public void get_User_details_where_is(String key, String parameterValues) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		req=given().spec(Utils.requestSpecification()).param(key, parameterValues);
	}
}
