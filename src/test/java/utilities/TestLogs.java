package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestLogs {

    public static void main(String[] args) {

        ExtentHtmlReporter configs = new ExtentHtmlReporter("./extentReport/report.html");
        configs.config().setTheme(Theme.DARK);
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(configs);
        System.out.println("start test");
        ExtentTest extentTest = reports.createTest("Google Search");
        extentTest.pass("It is passing");
        extentTest.fail("didn't match. FAIL!");
        reports.flush();
        System.out.println("completed");
    }

}
