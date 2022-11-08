package ru.yandex.practikum.pageObject;


import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.actions;
import static org.openqa.selenium.By.linkText;

public class LoginPage extends BasePage{

    public LoginPage getRegistrationLink() {
        $(linkText("Зарегистрироваться")).click();
        return page(LoginPage.class);
    }
    // метод заполнения поля ввода email
    public RegistrationPage setEmail(String email) {
        SelenideElement nameField = $(byText("Email"));
        actions().moveToElement(nameField).click(nameField).sendKeys(email).perform();
        return page(RegistrationPage.class);
    }
    // метод заполнения поля ввода пароля
    public RegistrationPage setPassword(String password) {
        SelenideElement nameField = $(byText("Пароль"));
        actions().moveToElement(nameField).click(nameField).sendKeys(password).perform();
        return page(RegistrationPage.class);
    }
    // метод нажатия кнопки Войти
    public void setLoginButton() {
        SelenideElement registrationButton = $(byText("Войти"));
        registrationButton.shouldBe(exist, Duration.ofSeconds(30)).click();
    }
    // метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке
    public void login(String email, String password ){
        setPassword(password);
        setEmail(email);
        setLoginButton();
    }
}
