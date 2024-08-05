package ru.praktikum.stellarburgers.nomoreparties.site.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserAPIMethods {
    protected String baseAuthUserEndpoint = "/api/auth";
    protected String userEndpoint = baseAuthUserEndpoint + "/user";
    protected String registerUserEndpoint = baseAuthUserEndpoint + "/register";
    protected String loginUserEndpoint = baseAuthUserEndpoint + "/login";


    @Step("Создаём тестового пользователя")
    public String createUser(User user) {
        Response response = this.sendPostRequestApiAuthRegister(user);

        return response.body().as(ResponseAuthorizationData.class).getAccessToken();
    }

    @Step("Удаляем тестового пользователя")
    public void deleteUser(User user) {
        String accessToken = this.loginUser(user);

        if (accessToken == null) return;

        this.sendDeleteRequestApiAuthUser(accessToken);
    }

    @Step("Логинимся под тестовым пользователем")
    public String loginUser(User user) {
        Response response = this.sendPostRequestApiAuthLogin(user);

        return response.body().as(ResponseAuthorizationData.class).getAccessToken();
    }

    @Step("Send POST request to /api/auth/register")
    private Response sendPostRequestApiAuthRegister(User user) {
        Response response =
            given()
                .header("Content-type","application/json")
                .and()
                .body(user)
                .when()
                .post(registerUserEndpoint);

        return response;
    }

    @Step("Send POST request to /api/auth/login")
    private Response sendPostRequestApiAuthLogin(User user) {
        Response response =
            given()
                .header("Content-type","application/json")
                .and()
                .body(user)
                .when()
                .post(loginUserEndpoint);

        return response;
    }

    @Step("Send DELETE request to /api/auth/user")
    private Response sendDeleteRequestApiAuthUser(String userToken) {
        Response response =
            given()
                .auth().oauth2(userToken)
                .header("Content-type","application/json")
                .delete(userEndpoint);

        return response;
    }

    @Step("Send GET request to /api/auth/user")
    private Response sendGetRequestApiAuthUser(String userToken) {
        Response response =
            given()
                .auth().oauth2(userToken)
                .header("Content-type","application/json")
                .get(userEndpoint);

        return response;
    }
}
