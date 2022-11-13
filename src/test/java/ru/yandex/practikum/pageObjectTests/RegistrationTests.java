package ru.yandex.practikum.pageObjectTests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practikum.pageObject.LoginPage;
import ru.yandex.practikum.pageObject.RegistrationPage;
import ru.yandex.practikum.api.dataGenerator.User;
import ru.yandex.practikum.api.dataGenerator.UserDataGenerator;
import static com.codeborne.selenide.Selenide.*;
public class RegistrationTests extends BaseTest{
    User user;
    RegistrationPage registration;
    LoginPage loginPage;
    @Before
    public void setUp(){
        loginPage = page(LoginPage.class);
        registration = open(RegistrationPage.URL, RegistrationPage.class);
        user = UserDataGenerator.getUserCreateFaker();
    }
    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Регистрация с рандомными данными")
    public void checkRegistrationWithValidCredentials() {
        registration.userRegistration(user);
        loginPage.checkUrlLogin();
    }

    @Test
    @DisplayName("Тест на проверку длинны пароля - пароль должен быть не меньше 6 символов (введено 5 символов)")
    public void checkRegistrationWithValidCredentialsSelenide() {
        user.setPassword("12345");
        registration.userRegistration(user);
        registration.checkInvalidPasswordMessage();
    }
}
