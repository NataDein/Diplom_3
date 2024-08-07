package ru.praktikum.stellarburgers.nomoreparties.site;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;


public class LogoutTest extends BaseTest {
    private LoginPage loginPage;
    private AccountPage accountPage;
    private Header header;

    @Before
    public void login() {
        this.accountPage = new AccountPage(driver);
        this.loginPage = new LoginPage(driver);
        this.header = new Header(driver);

        // Создаём пользователя
        this.userApi.createUser(this.testUser);

        goToPage(loginPage.getPageRoute());

        loginPage.setEmail(this.testUser.getEmail());
        loginPage.setPassword(this.testUser.getPassword());

        loginPage.clickLoginButton();
    }

    @After
    public void cleanData() {
        // Очищаем данные
        this.userApi.deleteUser(this.testUser);
    }

    @Test
    @DisplayName("Logout by logout link on account page")
    @Description("Should logout by logout link on account page")
    public void logoutByLogoutLink() {
        header.clickAccountLink();

        Assert.assertTrue(
            "Перешли на страницу аккаунта после клика на его ссылку в шапке",
            accountPage.checkIsPageOpened()
        );

        accountPage.clickExitButton();

        Assert.assertTrue(
            "Перешли на страницу входа после клика на ссылку на странице регистрации",
            loginPage.checkIsPageOpened()
        );
    }
}
