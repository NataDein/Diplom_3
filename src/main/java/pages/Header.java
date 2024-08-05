package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private final WebDriver driver;

    public Header(WebDriver driver) { this.driver = driver; }

    private final By logoLinkLocator = By.xpath(".//header/.//div[contains(@class, 'AppHeader_header__logo')]/a");
    private final By accountLinkLocator = By.xpath(".//header/.//a/.//p[text() = 'Личный Кабинет']");
    private final By constructorLinkLocator = By.xpath(".//header/.//a/.//p[text() = 'Конструктор']");
    private final By ordersListLinkLocator = By.xpath(".//header/.//a/.//p[text() = 'Лента Заказов']");


    public void clickLogoLink() { driver.findElement(logoLinkLocator).click(); }
    public void clickAccountLink() { driver.findElement(accountLinkLocator).click(); }
    public void clickConstructorLink() { driver.findElement(constructorLinkLocator).click(); }
    public void clickOrdersListLink() { driver.findElement(ordersListLinkLocator).click(); }
}
