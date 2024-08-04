package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// https://stellarburgers.nomoreparties.site/account
// class="Account_account__vgk_w"

public class AccountPage {
    private final WebDriver driver;

    public AccountPage(WebDriver driver) { this.driver = driver; }

    private final By exitButtonLocator = By.xpath("");
    private final By accountBlockLocator = By.xpath("");

    public void clickExitButton() { driver.findElement(exitButtonLocator).click(); }

    public String getErrorNotificationText() {
        ExpectedCondition<WebElement> isElementInDOM = ExpectedConditions.presenceOfElementLocated(accountBlockLocator);

        new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(isElementInDOM);

        return driver.findElement(accountBlockLocator).getText();
    }
}
