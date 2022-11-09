package ru.yandex.practikum.pageObjectTests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.practikum.pageObject.LoginPage;
import ru.yandex.practikum.pageObject.MainPage;
import ru.yandex.practikum.pageObject.RegistrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class LoginTests {
    @Test
    @DisplayName("Проверка входа через кнопку на главной странице - Войти в аккаунт")
    public void checkLoginThroughButtonLogin() throws InterruptedException {
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage();
        mainPage.getLoginButton();
        LoginPage loginPage = new LoginPage();
        loginPage.login("testik285554564@gmail.com", "12345jhbbjkn6");
        //проверка - ожидается переход на стартовую страницу
        String expected = "https://stellarburgers.nomoreparties.site/";
        assertEquals("Ожидался переход на стартовую страницу", expected, url());
        //на стратовой странице появляется кнопка "Оформить заказ"
        String expectedButton = "Оформить заказ";
        assertEquals("Ожидался переход на страницу входа", expectedButton, $(byText("Оформить заказ")).getText());

    }
    @Test
    @DisplayName("Проверка входа через кнопку на главной странице - Личный кабинет")
    public void checkLoginThroughButtonCabinet() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.getCabinet();
        LoginPage loginPage = new LoginPage();
        loginPage.login("testik285554564@gmail.com", "12345jhbbjkn6");
        //проверка - ожидается переход на стартовую страницу
        String expected = "https://stellarburgers.nomoreparties.site/";
        assertEquals("Ожидался переход на стартовую страницу", expected, url());
        //на стратовой странице появляется кнопка "Оформить заказ"
        String expectedButton = "Оформить заказ";
        assertEquals("Ожидался переход на страницу входа", expectedButton, $(byText("Оформить заказ")).getText());
    }
}