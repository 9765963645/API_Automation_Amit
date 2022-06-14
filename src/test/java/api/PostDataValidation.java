package api;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ApiUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PostDataValidation {
    @BeforeClass
    public void setup() throws IOException {
        ApiUtils.readAPIConfigs();
        ApiUtils.setBaseURL();
    }
    public static Response response;
    @Feature("API Test")
    @Story("API-001: post Request")
    @Description("to test new user is created when create user api is called")
    @Test(priority = 1,description = "to verify new user is created when create user api is called")
    public void postRequest() throws IOException {
        String body = Files.readString(Path.of(System.getProperty("user.dir") + "/src/test/java/api_test_data/CreateUserBody.json"));
         response = ApiUtils.postRequest("/users",body);
        Assert.assertEquals(response.statusCode(),201,"status code mismatch");
    }
}
