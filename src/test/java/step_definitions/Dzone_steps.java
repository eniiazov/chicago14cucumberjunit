package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.Driver;
import utilities.TempStorage;

public class Dzone_steps {


    @Given("user goes to {string}")
    public void user_goes_to(String url) {
        Driver.getDriver().get(url);
    }

    @Given("user takes header")
    public void user_takes_header() {
        String s = Driver.getDriver().findElement(By.xpath("//h1")).getText();
        TempStorage.addData("test", s);
    }

    @Then("user takes header of that page")
    public void user_takes_header_of_that_page() {
        String s2 = Driver.getDriver().findElement(By.xpath("//h1")).getText();
        TempStorage.addData("test2", s2);
    }

    @Then("user compares two headers")
    public void user_compares_two_headers() {
        Assert.assertEquals(TempStorage.getData("test"), TempStorage.getData("test2"));
    }

}
