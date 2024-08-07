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
    protected WebDriver driver;
    private String yaBrowserPath;

    private final String siteUrl = "https://stellarburgers.nomoreparties.site";

    protected final User testUser = new User("test-email@test.ru", "password", "TestName");
    protected final UserAPIMethods userApi = new UserAPIMethods();

    @Before
    public void init() {
        RestAssured.baseURI = this.siteUrl;

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
        driver.get(pageRoute == null ? siteUrl : siteUrl + pageRoute);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
