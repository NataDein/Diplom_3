package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// https://stellarburgers.nomoreparties.site/
// Соберите бургер

public class ConstructorPage {
    private final WebDriver driver;

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By pageHaederLocator = By.xpath("");

    public String getPageHeaderText() {
        ExpectedCondition<WebElement> isElementInDOM = ExpectedConditions.presenceOfElementLocated(pageHaederLocator);

        new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(isElementInDOM);

        return driver.findElement(pageHaederLocator).getText();
    }
}
