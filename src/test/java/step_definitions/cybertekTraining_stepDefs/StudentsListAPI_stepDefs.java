package step_definitions.cybertekTraining_stepDefs;

import ApiModels.Student;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import utilities.APIUtil;

public class StudentsListAPI_stepDefs {

    @Given("user gets students list with {string}")
    public void user_gets_students_list_with(String resource) {

        APIUtil.hitGET(resource);
    }

    @Given("user validates data from response by batch number {string}")
    public void user_validates_data_from_response_by_batch_number(String batchID) {
        for(Student student: APIUtil.getResponseBody().getStudents()){
            String batchIDactual = student.getBatch()+"";
            Assert.assertEquals("Student Batch ID failed", batchID, batchIDactual);
        }
    }

}
