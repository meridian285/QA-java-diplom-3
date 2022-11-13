package ru.yandex.practikum.pageObjectTests;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practikum.pageObject.*;
import ru.yandex.practikum.api.steps.UserSteps;
import ru.yandex.practikum.api.dataGenerator.User;
import ru.yandex.practikum.api.dataGenerator.UserDataGenerator;

import static com.codeborne.selenide.Selenide.*;

public class ProfileTests extends BaseTest{
    User user;
    LoginPage loginPage;
    MainPage mainPage;
    UserSteps userSteps;
    ProfilePage profilePage;
    String accessToken;

    @Before
    public void setUp(){
        mainPage = open(MainPage.URL,MainPage.class);
        loginPage = page(LoginPage.class);
        user = UserDataGenerator.getUserCreateFaker();
        userSteps = new UserSteps();
        profilePage = page(ProfilePage.class);
    }
    @After
    public void tearDown() {
        webdriver().driver().close();
        userSteps.deleteUser(accessToken);
    }
    @Test
    @DisplayName("Переход по клику на личный кабинет")
    public void checkClickCabinetLink(){
        accessToken = userSteps.create(user).then().extract().path("accessToken");
        mainPage.clickSingInButton();
        loginPage.login(user);
        mainPage.clickCabinet();
        profilePage.checkProfileUrl();
    }
    @Test
    @DisplayName("Тест на переход из личного кабинета в конструктор по клику на Конструктор")
    public void checkClickConstructorInTheProfile(){
        accessToken = userSteps.create(user).then().extract().path("accessToken");
        mainPage.clickSingInButton();
        loginPage.login(user);
        mainPage.clickCabinet();
        profilePage.clickConstructorButton();
        mainPage.checkPlaceOrderButton();
    }
    @Test
    @DisplayName("Тест на переход из личного кабинета в конструктор по клику на логотип")
    public void checkClickLogoInTheProfile(){
        accessToken = userSteps.create(user).then().extract().path("accessToken");
        mainPage.clickSingInButton();
        loginPage.login(user);
        mainPage.clickCabinet();
        profilePage.clickLogoBurger();
        mainPage.checkPlaceOrderButton();
    }
    @Test
    @DisplayName("Тест на выход из аккаунта")
    public void checkClickLogoffInTheProfile(){
        accessToken = userSteps.create(user).then().extract().path("accessToken");
        mainPage.clickSingInButton();
        loginPage.login(user);
        mainPage.clickCabinet();
        profilePage.clickLogoffButton();
        loginPage.checkUrlLogin();
    }
}
