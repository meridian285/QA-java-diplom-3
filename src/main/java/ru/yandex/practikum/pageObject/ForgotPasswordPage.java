package ru.yandex.practikum.pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    // локатор ссылки Войти
    @FindBy(how = How.LINK_TEXT,using = "Войти")
    private SelenideElement singInLink;

    @Step("Метод нажатия на ссылку Войти")
    public void clickSingInLick(){
        singInLink.click();
    }
}
