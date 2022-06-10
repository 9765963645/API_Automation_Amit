package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ApiUtils;

import java.io.IOException;

public class PostDataValidation {
    @Test(priority = 1)
    public void postRequest() throws IOException {
        ApiUtils.readAPIConfigs();
        ApiUtils.setup();
        RequestSpecification httprequest= RestAssured.given();
        JSONObject requestparam=new JSONObject();
        requestparam.put("employee_name","Amit");
        requestparam.put("employee_salary","50000");
        requestparam.put("employee_age","50");
        requestparam.put("profile_image","");
        httprequest.header("Content-Type","application/json");
        httprequest.body(requestparam.toJSONString());
        String end_point=ApiUtils.api_config.getProperty("create_user_end_point");
        Response response=httprequest.post(end_point,requestparam);
        String responseBoday = response.getBody().asString();
        Assert.assertEquals(response.statusCode(),201,"status code mismatch");
        System.out.println(responseBoday);
    }
}
