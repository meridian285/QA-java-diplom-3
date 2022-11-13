package ru.yandex.practikum.pageObjectTests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class  BaseTest {
    @Before
    public void startBeforeEveryTest(){
        String pathYandex = "yandexdriver.exe";
        String pathChrome = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathChrome);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }
}