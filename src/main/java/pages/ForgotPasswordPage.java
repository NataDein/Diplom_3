package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// https://stellarburgers.nomoreparties.site/forgot-password
// Восстановление пароля

public class ForgotPasswordPage {
    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailFieldLocator = By.xpath("");

    private final By recoveryButtonLocator = By.xpath("");

    public void setEmail(String value) {
        driver.findElement(emailFieldLocator).sendKeys(value);
    }

    public void clickRecoveryButton() {
        driver.findElement(recoveryButtonLocator).click();
    }
}
