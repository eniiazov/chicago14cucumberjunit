package apiTests;

import ApiModels.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Config;

public class TeacherAPI {

    @Test
    public void departmentNameTest(){
        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/department/Computer");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

        JsonPath jsonPath = response.jsonPath();
        int size = jsonPath.getList("teachers").size();

        for(int i = 0; i < size; i++){
            String path = "teachers[" + i + "].department";
            String department = jsonPath.get(path);
            System.out.println(department);
            Assert.assertEquals("Department failed at: " + i, "Computer", department);
        }
    }


    @Test
    public void emailValidationTeacherAPI() throws Exception{
        Response response = RestAssured.get(Config.getProperty("baseURL") + "/teacher/all");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

        Assert.assertEquals("List of Teachers API failed", 200, response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        ResponseBody rb =  objectMapper.readValue(response.asString(), ResponseBody.class);

        System.out.println(rb.getTeachers().size());

        for(int i = 0; i < rb.getTeachers().size(); i++){
            String email = rb.getTeachers().get(i).getEmailAddress();
            if(email.contains("@") && email.contains(".")){
                continue;
            }
            System.out.println(email);

        }


    }


}

















