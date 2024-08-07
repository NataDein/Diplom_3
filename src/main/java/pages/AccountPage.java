package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// https://stellarburgers.nomoreparties.site/account/profile

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) { super(driver, "/account/profile"); }

    private final By exitButtonLocator = By.xpath(".//button[text() = 'Выход']");
    private final By accountBlockLocator = By.xpath("");

    @Step("Клик по кнопке выхода")
    public void clickExitButton() { driver.findElement(exitButtonLocator).click(); }
}
