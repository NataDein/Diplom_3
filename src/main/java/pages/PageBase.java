package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    protected final WebDriver driver;
    private final String pageRoute;

    public PageBase(WebDriver driver, String pageRoute) {
        this.driver = driver;
        this.pageRoute = pageRoute;
    }

    public String getPageRoute() { return this.pageRoute; }

    public boolean checkIsPageOpened() {
        ExpectedCondition<Boolean> isPageOpened = ExpectedConditions.urlMatches(this.pageRoute + "$");

        new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(isPageOpened);

        return isPageOpened.apply(driver);
    }
}
