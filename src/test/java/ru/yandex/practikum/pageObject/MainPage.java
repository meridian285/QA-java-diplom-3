package ru.yandex.practikum.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends BasePage{

    public MainPage getLoginButton(){
        $(byText("Войти в аккаунт")).click();
        return page(MainPage.class);
    }
    public MainPage getPersonalArea(){
        $(byText("Личный Кабинет")).click();
        return page(MainPage.class);
    }
}
