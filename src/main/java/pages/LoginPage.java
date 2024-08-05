package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver, "/login");
    }

    private final By emailFieldLocator = By.xpath(".//form/.//label[text() = 'Email']/following::input[1]");
    private final By passwordFieldLocator = By.xpath(".//form/.//label[text() = 'Пароль']/following::input[1]");
//    input input_type_password [input_status_error]
    private final By errorNotificationLocator = By.xpath(".//p[contains(@class, 'input__error')]");

    private final By loginButtonLocator = By.xpath(".//button[text() = 'Войти']");
    private final By registerLinkLocator = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private final By forgotPasswordLinkLocator = By.xpath(".//a[text() = 'Восстановить пароль']");


    public void fillOutLoginForm() {
        this.setEmail("test-email@test.ru");
        this.setPassword("password");
    }

    public void setEmail(String value) {
        driver.findElement(emailFieldLocator).sendKeys(value);
    }

    public void setPassword(String value) { driver.findElement(passwordFieldLocator).sendKeys(value); }

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
}
