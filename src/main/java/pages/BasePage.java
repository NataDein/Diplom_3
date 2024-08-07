package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final WebDriver driver;
    @Getter
    private final String pageRoute;

    public BasePage(WebDriver driver, String pageRoute) {
        this.driver = driver;
        this.pageRoute = pageRoute;
    }

    @Step("Проверка открыта ли страница")
    public boolean checkIsPageOpened() {
        ExpectedCondition<Boolean> isPageOpened = ExpectedConditions.urlMatches(this.pageRoute + "$");

        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(isPageOpened);

        return isPageOpened.apply(driver);
    }
}
