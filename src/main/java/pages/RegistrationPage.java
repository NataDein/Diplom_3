package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

// Регистрация

public class RegistrationPage extends PageBase {
    public RegistrationPage(WebDriver driver) {
        super(driver, "/register");
    }

    private final By nameFieldLocator = By.xpath(".//form/.//label[text() = 'Имя']/following::input[1]");
    private final By emailFieldLocator = By.xpath(".//form/.//label[text() = 'Email']/following::input[1]");
    private final By passwordFieldLocator = By.xpath(".//form/.//label[text() = 'Пароль']/following::input[1]");
    private final By errorNotificationLocator = By.xpath(".//p[contains(@class, 'input__error')]");
    private final By registerButtonLocator = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private final By loginLinkLocator = By.xpath(".//a[text() = 'Войти']");

    @Step("Запись имени пользователя")
    public void setName(String value) { driver.findElement(nameFieldLocator).sendKeys(value); }

    @Step("Запись email'а пользователя")
    public void setEmail(String value) {
        driver.findElement(emailFieldLocator).sendKeys(value);
    }

    @Step("Запись пароля пользователя")
    public void setPassword(String value) { driver.findElement(passwordFieldLocator).sendKeys(value); }

    @Step("Отправка данных для регистрации")
    public void clickRegisterButton() { driver.findElement(registerButtonLocator).click(); }

    @Step("Клик по ссылке перехода на экран логина")
    public void clickLoginLink() { driver.findElement(loginLinkLocator).click(); }

    @Step("Проверка наличия ошибки невалидного пароля")
    public boolean checkNotificationOfIncorrectPassword() {
        ExpectedCondition<WebElement> isElementInDOM = ExpectedConditions.presenceOfElementLocated(errorNotificationLocator);

        new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(isElementInDOM);

        return Objects.equals(driver.findElement(errorNotificationLocator).getText(), "Некорректный пароль");
    }
}
