package ru.yandex.practikum.pageObjectTests;


import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.practikum.pageObject.LoginPage;
import ru.yandex.practikum.pageObject.MainPage;
import ru.yandex.practikum.pageObject.RegistrationPage;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

import static org.junit.Assert.assertEquals;

public class RegistrationTests{
//    @BeforeClass
//    public static void startBeforeEveryTest(){
//        open("https://stellarburgers.nomoreparties.site/register");
//    }

    @Test
    @DisplayName("Регистрация с рандомными данными")
    public void checkRegistrationWithValidCredentials() throws InterruptedException {
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.login("irкdtrwerhgj","oерqwe45in@mail.ru", "12stwre456");
        Thread.sleep(3000);
        String expected = "https://stellarburgers.nomoreparties.site/login";
        assertEquals("Ожидался переход на страницу входа", expected, url());
    }

    @Test
    @DisplayName("Тест на проверку длинны пароля - пароль должен быть не меньше 6 символов (введено 5 символов)")
    public void checkRegistrationWithValidCredentialsSelenide() throws InterruptedException {
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.login("dgeetgfbrth","erggegrtae@mail.ru","12345");
        String expected = "Некорректный пароль";
        assertEquals("Ожидалась ошибка - Некорректный пароль", expected, $(byText("Некорректный пароль")).getText());
    }
}
