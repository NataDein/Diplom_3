package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// https://stellarburgers.nomoreparties.site/account/profile

public class AccountPage extends PageBase {
    public AccountPage(WebDriver driver) { super(driver, "/account/profile"); }

    private final By exitButtonLocator = By.xpath(".//button[text() = 'Выход']");
    private final By accountBlockLocator = By.xpath("");

    @Step("Клик по кнопке выхода")
    public void clickExitButton() { driver.findElement(exitButtonLocator).click(); }
}
