package apiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

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
}
