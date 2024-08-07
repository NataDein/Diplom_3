package ru.praktikum.stellarburgers.nomoreparties.site;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.stellarburgers.nomoreparties.site.api.User;
import ru.praktikum.stellarburgers.nomoreparties.site.api.UserAPIMethods;

public class BaseTest {
    public static WebDriver driver;
    public static String yaBrowserPath;

    protected final String SITE_URL = "https://stellarburgers.nomoreparties.site";

    protected final User TEST_USER = new User("test-email@test.ru", "password", "TestName");
    protected final UserAPIMethods USER_API = new UserAPIMethods();

    @Before
    public void init() {
        RestAssured.baseURI = this.SITE_URL;

        yaBrowserPath = System.getenv("YA_BROWSER_PATH");

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

                options.setBinary(yaBrowserPath);

                return new ChromeDriver(options);
            default: throw new IllegalArgumentException("Unsupported browser type");
        }
    }

    @Step("Переход на страницу")
    public void goToPage(String pageRoute) {
        driver.get(pageRoute == null ? SITE_URL : SITE_URL + pageRoute);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
