package ru.praktikum.stellarburgers.nomoreparties.site;

import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Keys;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {
    @Test
    public void registrationWithValidData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        goToPage(registrationPage.getPageRoute());

        registrationPage.setName("TestName");
        registrationPage.setEmail(RandomString.make() + "@test.ru");
        registrationPage.setPassword("password");

        registrationPage.clickRegisterButton();

        Assert.assertTrue(
            "Перешли на страницу входа после успешной регистрации",
            loginPage.checkIsPageOpened()
        );
    }

    @Test
    public void setShortPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        goToPage(registrationPage.getPageRoute());

        registrationPage.setPassword("12345");

        registrationPage.clickRegisterButton();

        Assert.assertTrue(
            "При слишком коротком значении в поле пароля всплывает предупреждение",
            registrationPage.checkNotificationOfIncorrectPassword()
        );
    }
}
