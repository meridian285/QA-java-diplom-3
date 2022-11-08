package ru.yandex.practikum.pageObject;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.actions;
import static org.openqa.selenium.By.linkText;

public class LoginPage extends BasePage{
    // локатор поля ввода email
    @FindBy(how = How.XPATH,using = "//*[text()='email']")
    private SelenideElement emailField;
    // локатор поля ввода пароля
    @FindBy(how = How.XPATH,using = "//*[text()='Пароль']")
    private SelenideElement passwordField;
    // локатор поля ввода email
    @FindBy(how = How.XPATH,using = "//*[text()='Войти']")
    private SelenideElement inputButton;


    public LoginPage getRegistrationLink() {
        $(linkText("Зарегистрироваться")).click();
        return page(LoginPage.class);
    }
    // метод заполнения поля ввода email
    public RegistrationPage setEmail(String email) {
        actions().moveToElement(emailField).click(emailField).sendKeys(email).perform();
        return page(RegistrationPage.class);
    }
    // метод заполнения поля ввода пароля
    public RegistrationPage setPassword(String password) {
        actions().moveToElement(passwordField).click(passwordField).sendKeys(password).perform();
        return page(RegistrationPage.class);
    }
    // метод нажатия кнопки Войти
    public void setLoginButton() {
        inputButton.shouldBe(exist, Duration.ofSeconds(30)).click();
    }
    // метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке
    public void login(String email, String password ){
        setPassword(password);
        setEmail(email);
        setLoginButton();
    }
}
