package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

// Регистрация

public class RegistrationPage {
    private final WebDriver driver;

    private final String pageRoute = "/register";

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageRoute() { return this.pageRoute; }

    private final By nameFieldLocator = By.xpath(".//form/.//label[text() = 'Имя']/following::input[1]");
    private final By emailFieldLocator = By.xpath(".//form/.//label[text() = 'Email']/following::input[1]");
    private final By passwordFieldLocator = By.xpath(".//form/.//label[text() = 'Пароль']/following::input[1]");
//    input input_type_password [input_status_error]
    private final By errorNotificationLocator = By.xpath(".//p[contains(@class, 'input__error')]");

    private final By registerButtonLocator = By.xpath(".//button[text() = 'Зарегистрироваться']");

    private final By loginLinkLocator = By.xpath("");

    public void setName(String value) { driver.findElement(nameFieldLocator).sendKeys(value); }

    public void setEmail(String value) {
        driver.findElement(emailFieldLocator).sendKeys(value);
    }

    public void setPassword(String value) { driver.findElement(passwordFieldLocator).sendKeys(value); }

    public void clickRegisterButton() { driver.findElement(registerButtonLocator).click(); }

    public void clickLoginLink() { driver.findElement(loginLinkLocator).click(); }

    public boolean checkNotificationOfIncorrectPassword() {
        ExpectedCondition<WebElement> isElementInDOM = ExpectedConditions.presenceOfElementLocated(errorNotificationLocator);

        new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(isElementInDOM);

        return Objects.equals(driver.findElement(errorNotificationLocator).getText(), "Некорректный пароль");
    }
}
