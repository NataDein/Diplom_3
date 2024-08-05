package ru.praktikum.stellarburgers.nomoreparties.site;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static String YA_BROWSER_PATH;

    protected final String SITE_URL = "https://stellarburgers.nomoreparties.site";

    @Before
    public void init() {
        YA_BROWSER_PATH = System.getenv("YA_BROWSER_PATH");

        driver = getDriver(
            System.getenv("BROWSER")
        );
    }

    private WebDriver getDriver(String browser) {
        if (browser == null) throw new IllegalArgumentException("Browser type is not provided");

        switch (browser.toLowerCase()) {
            case "chrome": return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();

                options.setBinary(YA_BROWSER_PATH);

                return new ChromeDriver(options);
            default: throw new IllegalArgumentException("Unsupported browser type");
        }
    }

    public void goToPage(String pageRoute) {
        driver.get(pageRoute == null ? SITE_URL : SITE_URL + pageRoute);
    }

    @After
    public void tearDown() {
//        driver.quit();
    }
}
