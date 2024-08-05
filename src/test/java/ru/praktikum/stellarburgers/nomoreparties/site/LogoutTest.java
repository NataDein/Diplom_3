package ru.praktikum.stellarburgers.nomoreparties.site;

import io.qameta.allure.Step;
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

        goToPage(loginPage.getPageRoute());

        loginPage.fillOutLoginForm();
        loginPage.clickLoginButton();
    }

    @Test
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
