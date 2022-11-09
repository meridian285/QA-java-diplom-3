package ru.yandex.practikum.pageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage{


    public MainPage getLoginButton(){
        $(By.xpath(".//*[text()='Войти в аккаунт']")).click();
        return page(MainPage.class);
    }
    public MainPage getCabinet(){
        $(byText("Личный Кабинет")).click();
        return page(MainPage.class);
    }
}
