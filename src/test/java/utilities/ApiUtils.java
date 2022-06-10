package utilities;
import io.restassured.RestAssured;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiUtils {
   public static Properties api_config;
 public static void readAPIConfigs() throws IOException {
     api_config = new Properties();
     FileInputStream prop = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resourse\\api_config.properties");
     api_config.load(prop);
 }
    public static void setup()
    {
        RestAssured.baseURI = api_config.getProperty("base_url");
    }

}
