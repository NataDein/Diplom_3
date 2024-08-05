package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private final WebDriver driver;

    public Header(WebDriver driver) { this.driver = driver; }

    private final By logoLinkLocator = By.xpath(".//header/.//div[contains(@class, 'AppHeader_header__logo')]/a");
    private final By accountLinkLocator = By.xpath(".//header/.//a/.//p[text() = 'Личный Кабинет']");
    private final By constructorLinkLocator = By.xpath(".//header/.//a/.//p[text() = 'Конструктор']");
    private final By ordersListLinkLocator = By.xpath(".//header/.//a/.//p[text() = 'Лента Заказов']");


    @Step("Клик по лого")
    public void clickLogoLink() { driver.findElement(logoLinkLocator).click(); }

    @Step("Клик по ссылке перехода в личный кабинет")
    public void clickAccountLink() { driver.findElement(accountLinkLocator).click(); }

    @Step("Клик по ссылке перехода на экран конструктора")
    public void clickConstructorLink() { driver.findElement(constructorLinkLocator).click(); }

    @Step("Клик по ссылке перехода на экран ленты заказов")
    public void clickOrdersListLink() { driver.findElement(ordersListLinkLocator).click(); }
}
