package ru.praktikum.stellarburgers.nomoreparties.site;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;


public class ConstructorRoutesTest extends BaseTest {
    private LoginPage loginPage;
    private ConstructorPage constructorPage;

    @Before
    public void runBeforeEachTest() {
        this.loginPage = new LoginPage(driver);
        this.constructorPage = new ConstructorPage(driver);

        goToPage(loginPage.getPageRoute());

        loginPage.fillOutLoginForm();
        loginPage.clickLoginButton();

        goToPage(constructorPage.getPageRoute());
    }

    @Test
    public void switchToSaucesTab() {
        constructorPage.clickSaucesTab();

        Assert.assertTrue(
            "Переключили на вкладку Соусы",
            constructorPage.checkIsSaucesTabActive()
        );
    }

    @Test
    public void switchToFillingsTab() {
        constructorPage.clickFillingsTab();

        Assert.assertTrue(
            "Переключили на вкладку Начинки",
            constructorPage.checkIsFillingsTabActive()
        );
    }

    @Test
    public void switchToBunsTab() {
        constructorPage.clickFillingsTab();
        constructorPage.clickBunsTab();

        Assert.assertTrue(
            "Переключили на вкладку Булки",
            constructorPage.checkIsBunsTabActive()
        );
    }
}
