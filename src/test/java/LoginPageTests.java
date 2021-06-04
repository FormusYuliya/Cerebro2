import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.json.JsonOutput;
import pages.DashboardPage;
import pages.LoginPage;
import pages.Table;

public class LoginPageTests extends BaseTest {
    LoginPage loginPage;

    @Test
    public void invalidLogin(){
        loginPage = new LoginPage(driver);
        loginPage.openURL(System.getProperty("siteURL"));
        String message = loginPage.invalidLogin("jdshfjsbdfsdf@dfdf.df", "werwer");
//        BaseTest.sleep();
        Assert.assertEquals("Text is not equal","Bad credentials", message);
    }

    @Test
    public  void validLogin(){
        System.out.println(System.getProperty("testParameter"));
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        DashboardPage dashboardPage = loginPage.validLogin("test.formus+31@gmail.com", "Qwerty123");
        BaseTest.sleep();
//        Assert.assertEquals(dashboardPage.getPageTitle(), "Operation Dashboard");
//        dashboardPage.getCasesList();
//        dashboardPage.strangeTest();

        System.out.println("Done");

    }

}
