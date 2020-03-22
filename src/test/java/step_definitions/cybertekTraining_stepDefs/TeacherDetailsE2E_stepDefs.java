package step_definitions.cybertekTraining_stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.cybertekTraning_pages.CBTHomepage;
import utilities.Config;
import utilities.Driver;

public class TeacherDetailsE2E_stepDefs {

    CBTHomepage cbtHomepage = new CBTHomepage();

    @Given("user goes to cybertek training application")
    public void user_goes_to_cybertek_training_application() {
        Driver.getDriver().get(Config.getProperty("cybertekTrainingURL"));
    }

    @Then("user opens teacher profile details page {string}")
    public void user_opens_teacher_profile_details_page(String teacherID) {
        cbtHomepage.teachersDropdown.click();
        cbtHomepage.allTeachersLink.click();
        cbtHomepage.teacherIDSeachInput.sendKeys(teacherID);
        cbtHomepage.searchBtn.click();
        cbtHomepage.avatar.click();
    }

    @Then("user cross validates teacher details on API and on UI")
    public void user_cross_validates_teacher_details_on_API_and_on_UI() {

    }
}
