package ru.praktikum.stellarburgers.nomoreparties.site;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;


public class HeaderRoutesTest extends BaseTest {
    private LoginPage loginPage;
    private ConstructorPage constructorPage;
    private Header header;
    private AccountPage accountPage;

    @Before
    public void runBeforeEachTest() {
        this.loginPage = new LoginPage(driver);
        this.constructorPage = new ConstructorPage(driver);
        this.accountPage = new AccountPage(driver);

        this.header = new Header(driver);

        goToPage(loginPage.getPageRoute());

        loginPage.fillOutLoginForm();
        loginPage.clickLoginButton();
    }


    @Test
    public void openAccountPageByLinkInHeader() {
        header.clickAccountLink();

        Assert.assertTrue(
            "Перешли на страницу аккаунта по клику на его ссылку в шапке",
            accountPage.checkIsPageOpened()
        );
    }

    @Test
    public void openConstructorPageByLinkInHeader() {
        goToPage("/account");

        header.clickConstructorLink();

        Assert.assertTrue(
            "Перешли на страницу конструктора по клику на его ссылку в шапке",
            constructorPage.checkIsPageOpened()
        );
    }

    @Test
    public void openConstructorPageByLogoInHeader() {
        goToPage("/account");

        header.clickLogoLink();

        Assert.assertTrue(
            "Перешли на страницу конструктора по клику на лого в шапке",
            constructorPage.checkIsPageOpened()
        );
    }
}
