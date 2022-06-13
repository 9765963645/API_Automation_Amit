package utilities;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiUtils {
    public static Properties api_config;
    public static RequestSpecification request;
    public static Response response;
    @Step("read API Configs")
    public static void readAPIConfigs() throws IOException {
        api_config = new Properties();
        FileInputStream prop = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resourse\\api_config.properties");
        api_config.load(prop);
    }
    @Step("set BaseURL")
    public static void setBaseURL() throws IOException {

        RestAssured.baseURI =api_config.getProperty("base_url");
    }
    @Step("Request Specification init Request")
    public static RequestSpecification initRequest() {
        response = null;
        request = null;
        request = RestAssured.given().filter(new AllureRestAssured());
        return request;
    }
    @Step("postRequest")
    public static Response postRequest(String endpoint, String formdata){
        String token = getToken();
        request = initRequest();
        request.header("Authorization", "Bearer "+token);
        request.header("Content-Type", "application/json");
        request.body(formdata);
        response =request.post(endpoint);
        return response;
    }

    @Step("get access token call")
    private static String getToken() {
        String token = ApiUtils.api_config.getProperty("access_token");
        return token;
    }
}
