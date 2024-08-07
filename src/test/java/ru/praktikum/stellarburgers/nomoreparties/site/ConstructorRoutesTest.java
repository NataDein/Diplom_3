package ru.praktikum.stellarburgers.nomoreparties.site;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
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

        // Создаём пользователя
        this.userApi.createUser(this.testUser);

        goToPage(loginPage.getPageRoute());

        loginPage.setEmail(this.testUser.getEmail());
        loginPage.setPassword(this.testUser.getPassword());

        loginPage.clickLoginButton();

        goToPage(constructorPage.getPageRoute());
    }

    @After
    public void cleanData() {
        // Очищаем данные
        this.userApi.deleteUser(this.testUser);
    }

    @Test
    @DisplayName("Switch to sauces tab")
    @Description("Should switch to sauces tab correctly")
    public void switchToSaucesTab() {
        constructorPage.clickSaucesTab();

        Assert.assertTrue(
            "Переключили на вкладку Соусы",
            constructorPage.checkIsSaucesTabActive()
        );
    }

    @Test
    @DisplayName("Switch to fillings tab")
    @Description("Should switch to fillings tab correctly")
    public void switchToFillingsTab() {
        constructorPage.clickFillingsTab();

        Assert.assertTrue(
            "Переключили на вкладку Начинки",
            constructorPage.checkIsFillingsTabActive()
        );
    }

    @Test
    @DisplayName("Switch to buns tab")
    @Description("Should switch to buns tab correctly")
    public void switchToBunsTab() {
        constructorPage.clickFillingsTab();
        constructorPage.clickBunsTab();

        Assert.assertTrue(
            "Переключили на вкладку Булки",
            constructorPage.checkIsBunsTabActive()
        );
    }
}
