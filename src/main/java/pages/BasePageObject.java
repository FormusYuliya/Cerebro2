package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

    WebDriver driver;
    WebElement wait;
    private Integer defaultWait = 20;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openURL(String url) {
        driver.get(url);
    }

    protected void type(WebElement element, String text) {
        click(element);
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected WebElement waitForVisibilityOfElement(WebElement element, Integer customWaitTime) {
        return getWebDriverWait(driver, customWaitTime).until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForVisibilityOfElement(WebElement element) {
        return waitForVisibilityOfElement(element, defaultWait);
    }

    private WebDriverWait getWebDriverWait(WebDriver driver, Integer timeOutInSeconds) {
        return new WebDriverWait(driver, timeOutInSeconds);

    }

    protected WebElement getSubElement(WebElement root, By locatorOfSubElement) {
        return root.findElement(locatorOfSubElement);
    }

}
