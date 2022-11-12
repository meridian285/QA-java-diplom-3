package ru.yandex.practikum.pageObjectTests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practikum.pageObject.ForgotPasswordPage;
import ru.yandex.practikum.pageObject.LoginPage;
import ru.yandex.practikum.pageObject.MainPage;
import ru.yandex.practikum.pageObject.RegistrationPage;
import ru.yandex.practikum.pageObject.api.steps.UserSteps;
import ru.yandex.practikum.pageObject.dataGenerator.User;
import ru.yandex.practikum.pageObject.dataGenerator.UserDataGenerator;

import static com.codeborne.selenide.Selenide.*;

public class LoginTests {
    User user;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    MainPage mainPage;
    UserSteps userSteps;
    ForgotPasswordPage forgotPasswordPage;
    String accessToken;
    @Before
    public void setUp(){
        mainPage = open(MainPage.URL,MainPage.class);
        loginPage = page(LoginPage.class);
        registrationPage = page(RegistrationPage.class);
        user = UserDataGenerator.getUserCreateFaker();
        userSteps = new UserSteps();
        forgotPasswordPage = page(ForgotPasswordPage.class);
    }
    @After
    public void tearDown() {
        webdriver().driver().close();
        userSteps.deleteUser(accessToken);
    }
    @Test
    @DisplayName("Проверка входа через кнопку на главной странице - Войти в аккаунт")
    public void checkLoginThroughButtonLogin() {
        accessToken = userSteps.create(user).then().extract().path("accessToken");
        mainPage.clickSingInButton();
        loginPage.login(user);
        mainPage.checkPlaceOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через кнопку на главной странице - Личный кабинет")
    public void checkLoginThroughButtonCabinet() {
        accessToken = userSteps.create(user).then().extract().path("accessToken");
        mainPage.clickCabinet();
        loginPage.login(user);
        mainPage.checkPlaceOrderButton();
    }
    @Test
    @DisplayName("Проверка входа через ссылку Войти на странице регистрации")
    public void checkLoginThroughLinkLoginOnRegistrationPage() {
        accessToken = userSteps.create(user).then().extract().path("accessToken");
        mainPage.clickSingInButton();
        loginPage.clickRegistrationLink();
        registrationPage.clickLoginLink();
        loginPage.login(user);
        mainPage.checkPlaceOrderButton();
    }
    @Test
    @DisplayName("Проверка входа через кнопку на главной странице - Личный кабинет")
    public void checkLoginThroughForgotPassword() throws InterruptedException {
        accessToken = userSteps.create(user).then().extract().path("accessToken");
        mainPage.clickSingInButton();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.clickSingInLick();
        loginPage.login(user);
        mainPage.checkPlaceOrderButton();
    }
}