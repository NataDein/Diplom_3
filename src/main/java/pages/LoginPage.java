package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class LoginPage {
    private final WebDriver driver;

    private final String pageRoute = "/login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By pageHeaderLocator = By.xpath("");
    private final By emailFieldLocator = By.xpath("");
    private final By passwordFieldLocator = By.xpath("");
//    input input_type_password [input_status_error]
    private final By errorNotificationLocator = By.xpath(".//p[contains(@class, 'input__error')]");

    private final By loginButtonLocator = By.xpath("");
    private final By registerLinkLocator = By.xpath("");
    private final By forgotPasswordLinkLocator = By.xpath("");

    public void setEmail(String value) {
        driver.findElement(emailFieldLocator).sendKeys(value);
    }

    public void setPassword(String value) {
        driver.findElement(passwordFieldLocator).sendKeys(value);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

    public void clickRegisterLink() { driver.findElement(registerLinkLocator).click(); }

    public void clickForgotPasswordLink() { driver.findElement(forgotPasswordLinkLocator).click(); }

    public String getErrorNotificationText() {
        ExpectedCondition<WebElement> isElementInDOM = ExpectedConditions.presenceOfElementLocated(errorNotificationLocator);

        new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(isElementInDOM);

        return driver.findElement(errorNotificationLocator).getText();
    }

    public boolean checkIsPageOpened() {
        ExpectedCondition<Boolean> isLoginPageOpened = ExpectedConditions.urlMatches(pageRoute + "$");

        new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(isLoginPageOpened);

        return isLoginPageOpened.apply(driver);
    }
}
