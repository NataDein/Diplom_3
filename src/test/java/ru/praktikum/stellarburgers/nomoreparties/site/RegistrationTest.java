package ru.praktikum.stellarburgers.nomoreparties.site;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("Registration with valid credentials and user's data")
    @Description("Should open registration page and create user with valid credentials and user's data")
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
        userApi.deleteUser(this.testUser);
    }

    @Test
    @DisplayName("Registration with short password in credentials")
    @Description("Should open registration page, pass incorrect value of password and catch validation error")
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
