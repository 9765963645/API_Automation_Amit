package api;

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
    @Test(priority = 1)
    public void postRequest() throws IOException {
        ApiUtils.readAPIConfigs();
        ApiUtils.setup();
        String body = Files.readString(Path.of(System.getProperty("user.dir") + "/src/test/java/api_test_data/CreateUserJsonBody.json"));
        String end_point=ApiUtils.api_config.getProperty("create_user_end_point");
        Response response = ApiUtils.post(end_point, body);
        Assert.assertEquals(response.statusCode(),201,"status code mismatch");

    }
}
