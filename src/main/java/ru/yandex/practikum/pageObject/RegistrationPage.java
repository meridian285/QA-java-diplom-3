package ru.yandex.practikum.pageObject;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.practikum.pageObject.dataGenerator.User;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RegistrationPage{
    public static final String URL = "http://stellarburgers.nomoreparties.site/register";

    //локатор поля ввода Password
    @FindBy(how = How.CSS, using = "input[name='Пароль']")
    protected SelenideElement passwordField;
    //локатор кнопки Зарегистрироваться
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    protected SelenideElement registrationButton;
    //локатор сообщения что пароль не подходит
    @FindBy(how = How.CSS, using = ".input__error")
    protected SelenideElement invalidPasswordMessage;
    //локатор ссылки Войти
    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj']")
    private SelenideElement loginLink;
    // локатор поля ввода Имени
    @FindBy(how = How.XPATH, using = "//form/fieldset[1]/div/div/input")
    protected SelenideElement nameField;
    //локатор поля ввода Email
    @FindBy(how = How.XPATH, using = "//form/fieldset[2]/div/div/input")
    protected SelenideElement emailField;

    @Step("метод заполнения поля ввода name")
    public void setUsername(String name) {
            nameField.setValue(name);
    }
    @Step("метод заполнения поля ввода email")
    public void setEmail(String email) {
            emailField.setValue(email);
    }
    @Step ("метод заполнения поля ввода пароля")
    public void setPassword(String password) {
            passwordField.setValue(password);
    }
    @Step("метод нажатия кнопки Зарегистрироваться")
    public void setRegistrationButton() {
        registrationButton.click();
    }
    @Step("метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке")
    public void userRegistration(User user){
        setUsername(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setRegistrationButton();
    }
    @Step("метод нажатия ссылки Войти")
    public void clickLoginLink() {
        loginLink.click();
    }
    @Step("Проверка что загрузился URL регистрации")
    public void checkRegistrationURL(){
        webdriver().shouldHave(url(URL));
    }
    @Step("Проверка что появилось сообщение Некорректный пароль")
    public void checkInvalidPasswordMessage(){
        invalidPasswordMessage.shouldBe(Condition.visible);
    }
}
