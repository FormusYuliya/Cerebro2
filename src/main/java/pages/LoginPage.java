package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePageObject {

    private String pageURL = "https://dev.cersq.com/";

    @FindBy(css = "h3[class='Auth__sub-title']")
    private WebElement pageTitle;

    @FindBy(css = "input[name='username']")
    private WebElement emailField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "div[class='Alert alert alert-danger fade show']")
    private WebElement alertMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openURL(pageURL);
    }

    private void login(String username, String pass) {
        type(emailField, username);
        type(passwordField, pass);
        click(loginButton);
    }

    public String invalidLogin(String username, String pass) {
        login(username, pass);
        waitForVisibilityOfElement(alertMessage);
        return alertMessage.getText();
    }

    public DashboardPage validLogin(String username, String pass) {
        login(username, pass);
        return new DashboardPage(driver);
    }

}
