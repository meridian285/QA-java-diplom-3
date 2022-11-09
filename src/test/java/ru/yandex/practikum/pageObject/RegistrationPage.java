package ru.yandex.practikum.pageObject;

import com.codeborne.selenide.ElementsCollection;
import net.datafaker.Faker;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class RegistrationPage{
    // локатор полей Имя, Email, Пароль
    @FindBy(how = How.CLASS_NAME, using = "input__textfield")
    private ElementsCollection inputs;

    // локатор кнопки Зарегистрироваться
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement registerButton;

    // локатор linkText Войти
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement loginText;

    // метод заполнения поля ввода name
    public RegistrationPage setUsername(String name) {
        SelenideElement nameField = $(byText("Имя"));
        actions().moveToElement(nameField).click(nameField).sendKeys(name).perform();
        return page(RegistrationPage.class);
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
    // метод нажатия кнопки Зарегистрироваться
    public void setRegistrationButton() {
        SelenideElement registrationButton = $(byText("Зарегистрироваться"));
        registrationButton.click();
    }
    // метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке
    public void login(String username, String email, String password ){
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setRegistrationButton();
    }
    // метод нажатия ссылки Войти
    public void setLoginLink() {
        SelenideElement registrationButton = $(linkText("Войти"));
        registrationButton.click();
    }
}
