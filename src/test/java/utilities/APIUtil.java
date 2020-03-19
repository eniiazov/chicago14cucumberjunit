package utilities;

import ApiModels.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class APIUtil {

    // CRUD Operation. One method for each operation.
    // One method should handle any APIs we are hitting.

    private static ResponseBody responseBody;

    public static void hitGET(String resource){
        String uri = Config.getProperty("baseURL") + resource;
        Response response = RestAssured.get(uri);

        System.out.println(response.asString());
        Assert.assertEquals("GET API hit failed", 200, response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        }
        catch (Exception j){
            j.printStackTrace();
        }
    }

    public static ResponseBody getResponseBody(){
        return responseBody;
    }


}
