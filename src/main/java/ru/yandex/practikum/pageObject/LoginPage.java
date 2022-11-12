package ru.yandex.practikum.pageObject;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.practikum.pageObject.dataGenerator.User;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginPage{
    public static final String URL = "http://stellarburgers.nomoreparties.site/login";
    // локатор поля ввода email
    @FindBy(how = How.XPATH,using = "//input[@name='name']")
    private SelenideElement emailField;
    // локатор поля ввода пароля
    @FindBy(how = How.XPATH,using = "//input[@name='Пароль']")
    private SelenideElement passwordField;
    // локатор поля ввода email
    @FindBy(how = How.XPATH,using = "//button[text()='Войти']")
    private SelenideElement inputButton;
    // локатор ссылки Зарегистрироваться
    @FindBy(how = How.LINK_TEXT,using = "Зарегистрироваться")
    private SelenideElement linkRegistration;
    @FindBy(how = How.LINK_TEXT,using = "Восстановить пароль")
    private SelenideElement linkForgotPassword;


    @Step("Метод нажатия на ссылку Зарегистрироваться")
    public void clickRegistrationLink() {
        linkRegistration.click();
    }
    @Step("Метод нажатия на ссылку Востановить пароль")
    public void clickForgotPasswordLink() {
        linkForgotPassword.click();
    }

    @Step ("метод заполнения поля ввода email")
    public void setEmail(String email) {
        emailField.setValue(email);
    }
    @Step ("метод заполнения поля ввода пароля")
    public void setPassword(String password) {
        passwordField.setValue(password);
    }
    @Step ("метод нажатия кнопки Войти")
    public void setLoginButton() {
        inputButton.click();
    }
    @Step ("метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке")
    public void login(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setLoginButton();
    }
    @Step("метод проверки загрузки страницы login")
    public void checkUrlLogin(){
        webdriver().shouldHave(url(URL));
    }
}
