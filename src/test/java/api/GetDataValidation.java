package api;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ApiUtils;
import java.io.IOException;

public class GetDataValidation {

    @Feature("API Test")
    @Story("API-001: Get Request")
    @Description("Get Request fetch user")
    @Test(priority = 1,description = "to verify user is fetch ")
    public void getDetails() throws IOException {
        //RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/employee";
        ApiUtils.readAPIConfigs();
        ApiUtils.setBaseURL();
        String end_point=ApiUtils.api_config.getProperty("create_user_end_point");
        RequestSpecification httprequest=RestAssured.given();
        Response response=httprequest.get(end_point);
        String responseBoday = response.getBody().asString();
        Assert.assertEquals(response.statusCode(),200,"status code mismatch");
        System.out.println(responseBoday);
    }

}
