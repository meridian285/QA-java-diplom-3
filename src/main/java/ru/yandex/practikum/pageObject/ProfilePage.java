package ru.yandex.practikum.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ProfilePage {
    String urlProfile = "http://stellarburgers.nomoreparties.site/account/profile";

    //локатор кнопки Конструктор
    @FindBy(how = How.LINK_TEXT, using = "Конструктор")
    private SelenideElement constructorButton;
    //локатор логотипа
    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoBurger;
    //локатор кнопки Выход
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoff;


    @Step("Клик по кнопке Конструктор в личном кабинете")
    public void clickConstructorButton(){
        constructorButton.click();
    }
    @Step("Клик по кнопке Конструктор в личном кабинете")
    public void clickLogoBurger(){
        logoBurger.click();
    }
    @Step("Проверка что загрузилась страница личного кабинета")
    public void checkProfileUrl(){
        webdriver().shouldHave(url(urlProfile));
    }
    @Step("Клик по кнопке Выход в личном кабинете")
    public void clickLogoffButton(){
        logoff.click();
    }

}
