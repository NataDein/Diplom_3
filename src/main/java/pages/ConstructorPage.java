package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

// https://stellarburgers.nomoreparties.site/

public class ConstructorPage extends PageBase {
    public ConstructorPage(WebDriver driver) { super(driver, "/"); }

    private final By bunsTabLocator = By.xpath(".//span[text() = 'Булки']");
    private final By saucesTabLocator = By.xpath(".//span[text() = 'Соусы']");
    private final By fillingsTabLocator = By.xpath(".//span[text() = 'Начинки']");
    private final By menuLocator = By.xpath(".//div[contains(@class, 'BurgerIngredients_ingredients__menuContainer')]");
    private final By tabMenuActiveLocator = By.xpath(".//section[contains(@class, 'BurgerIngredients_ingredients')]/.//div[contains(@class, 'tab_tab_type_current')]");


    @Step("Клик по вкладке Булки")
    public void clickBunsTab() {
        driver.findElement(bunsTabLocator).click();
    }

    @Step("Клик по вкладке Соусы")
    public void clickSaucesTab() { driver.findElement(saucesTabLocator).click(); }

    @Step("Клик по вкладке Начинки")
    public void clickFillingsTab() { driver.findElement(fillingsTabLocator).click(); }

    @Step("Проверка активна ли вкладка Булки")
    public boolean checkIsBunsTabActive() {
        return Objects.equals(driver.findElement(tabMenuActiveLocator).getText(), "Булки");
    }

    @Step("Проверка активна ли вкладка Соусы")
    public boolean checkIsSaucesTabActive() {
        return Objects.equals(driver.findElement(tabMenuActiveLocator).getText(), "Соусы");
    }

    @Step("Проверка активна ли вкладка Начинки")
    public boolean checkIsFillingsTabActive() {
        return Objects.equals(driver.findElement(tabMenuActiveLocator).getText(), "Начинки");
    }
}
