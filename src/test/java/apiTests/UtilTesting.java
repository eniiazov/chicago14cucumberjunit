package apiTests;

import ApiModels.RequestBody;
import ApiModels.Student;
import ApiModels.Teacher;
import org.junit.Assert;
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

    @Test
    public void batchTesting(){
        APIUtil.hitGET("/student/all");

        int index = 0;

        for(Student s: APIUtil.getResponseBody().getStudents()){
            if(s.getBatch() >= 7 && s.getBatch() <= 14){
                index++;
                continue;
            }
            Assert.fail("Student Batch Failed at: " + index);
        }
    }


    @Test
    public void postTesting(){
        RequestBody teacher = new RequestBody();
        teacher.setEmailAddress("new@gmail.com");
        teacher.setFirstName("Tim");
        teacher.setLastName("Ronaldo");
        teacher.setJoinDate("01/02/2003");
        teacher.setSalary(5004);
        teacher.setBatch(12);
        teacher.setBirthDate("01/01/1987");
        teacher.setGender("Male");
        teacher.setPassword("jb123");
        teacher.setPhone("2342-23423413");
        teacher.setPremanentAddress("32 main street");
        teacher.setSection("OK");
        teacher.setSubject("Coding");
        teacher.setDepartment("CS");

        APIUtil.hitPOST("/teacher/create", teacher);


    }

}












