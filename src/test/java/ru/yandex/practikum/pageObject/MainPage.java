package ru.yandex.practikum.pageObject;

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
