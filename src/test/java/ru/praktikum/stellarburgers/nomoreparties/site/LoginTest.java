package ru.praktikum.stellarburgers.nomoreparties.site;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;


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
    }

    @Step
    public void login() {
        loginPage.fillOutLoginForm();
        loginPage.clickLoginButton();

        Assert.assertTrue(
            "Перешли на страницу конструктора после успешной регистрации",
            constructorPage.checkIsPageOpened()
        );
    }

    @Test
    public void loginOnLoginPage() {
        goToPage(loginPage.getPageRoute());

        login();
    }

    @Test
    public void loginOnAccountLink() {
        goToPage(constructorPage.getPageRoute());

        header.clickAccountLink();

        Assert.assertTrue(
            "Перешли на страницу входа после клика на ссылку на странице регистрации",
            loginPage.checkIsPageOpened()
        );

        login();
    }

    @Test
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
    public void loginOnForgotPasswordPage() {
        goToPage(forgotPasswordPage.getPageRoute());

        forgotPasswordPage.clickLoginLink();

        Assert.assertTrue(
            "Перешли на страницу входа после клика на ссылку на странице регистрации",
            loginPage.checkIsPageOpened()
        );

        login();
    }
}
