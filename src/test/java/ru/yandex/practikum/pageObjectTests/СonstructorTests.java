package ru.yandex.practikum.pageObjectTests;

import io.qameta.allure.Step;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practikum.pageObject.MainPage;
import static com.codeborne.selenide.Selenide.*;

public class СonstructorTests {
    MainPage mainPage;
    @Before
    public void setUp(){
        mainPage = open(MainPage.URL,MainPage.class);
    }
    @Test
    @Step("Проверка на переключение вкладок с ингредиентами Соусы")
    public void checkSwitchingBetweenSouseTabs(){
        mainPage.clickSouseTab();
        mainPage.checkSouseTabActive();
    }
    @Test
    @Step("Проверка на переключение вкладок с ингредиентами Начинки")
    public void checkSwitchingBetweenFillingsTabs() {
        mainPage.clickFillingsTab();
        mainPage.checkFillingsTabActive();
    }
    @Test
    @Step("Проверка на переключение вкладок с ингредиентами Булки")
    public void checkSwitchingBetweenBunsTabs() {
        mainPage.clickFillingsTab();
        mainPage.clickBunsTab();
        mainPage.checkBunsTabActive();
    }
}
