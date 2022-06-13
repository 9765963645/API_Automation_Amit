package api;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ApiUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PostDataValidation {
    public static Response response;
    @Feature("API Test")
    @Story("API-001: post Request")
    @Description("to test new user is created when create user api is called")
    @Test(priority = 1,description = "to verify new user is created when create user api is called")
    public void postRequest() throws IOException {
        ApiUtils.readAPIConfigs();
        ApiUtils.setBaseURL();
        String body = Files.readString(Path.of(System.getProperty("user.dir") + "/src/test/java/api_test_data/CreateUserBody.json"));
//        System.out.println(body);
        String end_point=ApiUtils.api_config.getProperty("/users");
//        System.out.println(end_point);
//        Response response = ApiUtils.postRequest(end_point, body);
//        System.out.println(response.getBody().asString());
//       Assert.assertEquals(response.statusCode(),201,"status code mismatch");
         response = ApiUtils.postRequest(end_point,body);
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);

    }
}
