package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private final WebDriver driver;

    public Header(WebDriver driver) { this.driver = driver; }

    private final By accountLinkLocator = By.xpath("");
    private final By constructorLinkLocator = By.xpath("");
    private final By ordersListLinkLocator = By.xpath("");

    public void clickAccountLink() { driver.findElement(accountLinkLocator); }
    public void clickConstructorLink() { driver.findElement(constructorLinkLocator); }
    public void clickOrdersListLink() { driver.findElement(ordersListLinkLocator); }
}
