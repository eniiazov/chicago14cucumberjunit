package step_definitions.cybertekTraining_stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.cybertekTraning_pages.CBTHomepage;
import utilities.APIUtil;
import utilities.Config;
import utilities.Driver;

public class TeacherDetailsE2E_stepDefs {

    CBTHomepage cbtHomepage = new CBTHomepage();

    @Given("user goes to cybertek training application")
    public void user_goes_to_cybertek_training_application() {
        Driver.getDriver().get(Config.getProperty("cybertekTrainingURL"));
    }

    @Then("user opens teacher profile details page {string}")
    public void user_opens_teacher_profile_details_page(String teacherID) throws Exception{
        cbtHomepage.teachersDropdown.click();
        cbtHomepage.allTeachersLink.click();
        Thread.sleep(500);
        cbtHomepage.teacherIDSeachInput.sendKeys(teacherID);
        cbtHomepage.searchBtn.click();
        cbtHomepage.avatar.click();
    }

    @Then("user cross validates teacher details on API and on UI")
    public void user_cross_validates_teacher_details_on_API_and_on_UI() {
        String apiFullName = APIUtil.getResponseBody().getTeachers().get(0).getFirstName() + " " + APIUtil.getResponseBody().getTeachers().get(0).getLastName();
        String uiFullName = cbtHomepage.fullName.getText();
        System.out.println(apiFullName);
        System.out.println(uiFullName);
        Assert.assertEquals("e2e full name verification failed", apiFullName, uiFullName);
        Assert.assertEquals("e2e phone verification failed", APIUtil.getResponseBody().getTeachers().get(0).getPhone().trim(), cbtHomepage.phoneNumber.getText().trim());
        Assert.assertEquals("e2e email verification failed", APIUtil.getResponseBody().getTeachers().get(0).getEmailAddress().trim(), cbtHomepage.email.getText().trim());
        Assert.assertEquals("e2e batch verification failed", APIUtil.getResponseBody().getTeachers().get(0).getBatch()+"".trim(), cbtHomepage.batch.getText().trim());
        Assert.assertEquals("e2e birthday verification failed", APIUtil.getResponseBody().getTeachers().get(0).getBirthDate().trim(), cbtHomepage.birthday.getText().trim());
        Assert.assertEquals("e2e join date verification failed", APIUtil.getResponseBody().getTeachers().get(0).getJoinDate().trim(), cbtHomepage.joinDate.getText().trim());
        Assert.assertEquals("e2e address verification failed", APIUtil.getResponseBody().getTeachers().get(0).getPremanentAddress().trim(), cbtHomepage.address.getText().trim());
        Assert.assertEquals("e2e gender verification failed", APIUtil.getResponseBody().getTeachers().get(0).getGender().trim(), cbtHomepage.gender.getText().trim());
        Assert.assertEquals("e2e salary verification failed", APIUtil.getResponseBody().getTeachers().get(0).getSalary()+"".trim(), cbtHomepage.salary.getText().trim());
        Assert.assertEquals("e2e section verification failed", APIUtil.getResponseBody().getTeachers().get(0).getSection().trim(), cbtHomepage.section.getText().trim());
        Assert.assertEquals("e2e subject verification failed", APIUtil.getResponseBody().getTeachers().get(0).getSubject().trim(), cbtHomepage.subject.getText().trim());

    }
}
