package apiTests;

import ApiModels.Teacher;
import org.junit.Test;
import utilities.APIUtil;

public class UtilTesting {

    @Test
    public void teacherTesting(){
        String resource = "/teacher/2192";

        APIUtil.hitGET(resource);

        System.out.println(APIUtil.getResponseBody().getTeachers().get(0).getFirstName());

        // APIUtil.getResponseBody() ==> ResponseBody object
    }

    @Test
    public void allTeacherTest(){
        APIUtil.hitGET("/teacher/all");

        for(Teacher t: APIUtil.getResponseBody().getTeachers()){
            if(t.getGender().equalsIgnoreCase("female")){
                System.out.println(t.getFirstName());
            }
        }
    }
}
