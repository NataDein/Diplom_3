package ru.praktikum.stellarburgers.nomoreparties.site;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;


public class LoginTest extends BaseTest {
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private ConstructorPage constructorPage;
    private ForgotPasswordPage forgotPasswordPage;
    private Header header;

    @Before
    public void runBeforeEachTest() {
        this.registrationPage = new RegistrationPage(driver);
        this.loginPage = new LoginPage(driver);
        this.constructorPage = new ConstructorPage(driver);
        this.forgotPasswordPage = new ForgotPasswordPage(driver);
        this.header = new Header(driver);

        // Создаём пользователя
        this.USER_API.createUser(this.TEST_USER);
    }

    @After
    public void cleanData() {
        // Очищаем данные
        this.USER_API.deleteUser(this.TEST_USER);
    }

    @Step("Входим в аккаунт под тестовым пользователем")
    public void login() {
        loginPage.setEmail(this.TEST_USER.getEmail());
        loginPage.setPassword(this.TEST_USER.getPassword());

        loginPage.clickLoginButton();

        Assert.assertTrue(
            "Перешли на страницу конструктора после успешной регистрации",
            constructorPage.checkIsPageOpened()
        );
    }

    @Test
    @DisplayName("Login by login page")
    @Description("Should login by form on login page")
    public void loginOnLoginPage() {
        goToPage(loginPage.getPageRoute());

        login();
    }

    @Test
    @DisplayName("Login by account link in header")
    @Description("Should open login page by account link in header and login by opened form")
    public void loginOnAccountLink() {
        goToPage(constructorPage.getPageRoute());

        header.clickAccountLink();

        Assert.assertTrue(
            "Перешли на страницу входа после клика на ссылку аккаунта в шапке",
            loginPage.checkIsPageOpened()
        );

        login();
    }

    @Test
    @DisplayName("Login by login link on register page")
    @Description("Should open login page by login link on register page and login by opened form")
    public void loginOnRegisterPage() {
        goToPage(registrationPage.getPageRoute());

        registrationPage.clickLoginLink();

        Assert.assertTrue(
            "Перешли на страницу входа после клика на ссылку на странице регистрации",
            loginPage.checkIsPageOpened()
        );

        login();
    }

    @Test
    @DisplayName("Login by login link on forgot password page")
    @Description("Should open login page by login link on forgot password page and login by opened form")
    public void loginOnForgotPasswordPage() {
        goToPage(forgotPasswordPage.getPageRoute());

        forgotPasswordPage.clickLoginLink();

        Assert.assertTrue(
            "Перешли на страницу входа после клика на ссылку на странице восстановления пароля",
            loginPage.checkIsPageOpened()
        );

        login();
    }
}
