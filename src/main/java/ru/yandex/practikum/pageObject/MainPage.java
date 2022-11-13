package ru.yandex.practikum.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Objects;

public class MainPage{
    public static final String URL = "http://stellarburgers.nomoreparties.site/";

    //локатор кнопки Личный кабинет
    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement cabinetButton;
    // локатор кнопки Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement singInButton;
    // локатор Кнопки Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement placeOrderButton;
    // локатор вкладки Соусы
    @FindBy(how = How.XPATH, using = "//span[@class='text text_type_main-default'][text()='Соусы']")
    private SelenideElement souseTab;
    // локатор вкладки Соусы
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement souseTab1;

    // локатор вкладки Начинки
    @FindBy(how = How.XPATH, using = "//span[@class='text text_type_main-default'][text()='Начинки']")
    private SelenideElement fillingsTab;
    // локатор вкладки Начинки
    @FindBy(how = How.XPATH, using = "//span[@class='text text_type_main-default'][text()='Булки']")
    private SelenideElement bunsTab;


    @Step("Клик по кнопке Личный кабинет")
    public void clickCabinet(){
        cabinetButton.click();
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public void clickSingInButton() {
        singInButton.click();
    }

    @Step("Проверка что загрузились нужная страница и есть кнопка Оформить заказ")
    public void checkPlaceOrderButton() {
        placeOrderButton.shouldBe(Condition.exist);
    }
    @Step("Проверка что загрузилась главная страница и отображается кнопка Войти в аккаунт")
    public void checkSingInButton() {
        singInButton.shouldBe(Condition.visible);
    }
    @Step("Метод для клика по вкладке Соусы")
    public void clickSouseTab(){
        souseTab.click();
    }
    @Step("Метод для клика по вкладке Начинки")
    public void clickFillingsTab(){
        fillingsTab.click();
    }
    @Step("Метод для клика по вкладке Булки")
    public void clickBunsTab(){
        bunsTab.click();
    }

    @Step("Метод для проверки что вкладка Соусы активна")
    public void checkSouseTabActive(){
        Objects.requireNonNull(souseTab.getAttribute("class")).contains("tab_tab__1SPyG tab_tab_type_current__2BEPc");
    }
    @Step("Метод для проверки что вкладка Начинки активна")
    public void checkFillingsTabActive(){
        Objects.requireNonNull(fillingsTab.getAttribute("class")).contains("tab_tab__1SPyG tab_tab_type_current__2BEPc");
    }
    @Step("Метод для проверки что вкладка Булки активна")
    public void checkBunsTabActive() {
        Objects.requireNonNull(bunsTab.getAttribute("class")).contains("tab_tab__1SPyG tab_tab_type_current__2BEPc");
    }
}
