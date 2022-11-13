package ru.yandex.practikum.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import ru.yandex.practikum.api.dataGenerator.User;

import static io.restassured.RestAssured.given;

public class UserSteps extends RestClient {
    public static String CREATE_USER = "api/auth/register";
    public static String DELETE = "api/auth/user";
    @Step("Регистрация пользователя")
    //create
    public Response create(User user) {
        Response response = given()
                .spec(getDefaultRequestSpec())
                .body(user)
                .post(CREATE_USER);
        return response;
    }
    @Step("Удаление пользователя")
    //create
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .header("authorization", accessToken)
                .spec(getDefaultRequestSpec())
                .delete(DELETE)
                .then();
    }
}