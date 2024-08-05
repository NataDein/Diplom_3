package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// https://stellarburgers.nomoreparties.site/forgot-password
// Восстановление пароля

public class ForgotPasswordPage extends PageBase {
    public ForgotPasswordPage(WebDriver driver) {
        super(driver, "/forgot-password");
    }

    private final By emailFieldLocator = By.xpath(".//form/.//label[text() = 'Email']/following::input[1]");
    private final By recoveryButtonLocator = By.xpath(".//button[text() = 'Восстановить']");
    private final By loginLinkLocator = By.xpath(".//a[text() = 'Войти']");



    @Step("Запись email'а пользователя")
    public void setEmail(String value) {
        driver.findElement(emailFieldLocator).sendKeys(value);
    }

    @Step("Клик по кнопке восстановления пароля")
    public void clickRecoveryButton() {
        driver.findElement(recoveryButtonLocator).click();
    }

    @Step("Клик по ссылке на экран входа")
    public void clickLoginLink() { driver.findElement(loginLinkLocator).click(); }
}
