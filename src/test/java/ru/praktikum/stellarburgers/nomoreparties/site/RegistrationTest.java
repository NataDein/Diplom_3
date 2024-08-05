package ru.praktikum.stellarburgers.nomoreparties.site;

import org.junit.*;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {
    @Test
    public void registrationWithValidData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        goToPage(registrationPage.getPageRoute());

        registrationPage.setName(this.testUser.getName());
        registrationPage.setEmail(this.testUser.getEmail());
        registrationPage.setPassword(this.testUser.getPassword());

        registrationPage.clickRegisterButton();

        Assert.assertTrue(
            "Перешли на страницу входа после успешной регистрации",
            loginPage.checkIsPageOpened()
        );

        // Очищаем данные
        userAPI.deleteUser(this.testUser);
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
