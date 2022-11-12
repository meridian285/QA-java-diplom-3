package ru.yandex.practikum.pageObjectTests;


import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.practikum.pageObject.LoginPage;
import ru.yandex.practikum.pageObject.MainPage;
import ru.yandex.practikum.pageObject.ProfilePage;
import ru.yandex.practikum.pageObject.api.steps.UserSteps;
import ru.yandex.practikum.pageObject.dataGenerator.User;
import ru.yandex.practikum.pageObject.dataGenerator.UserDataGenerator;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public abstract class  BaseTest {
    private User user;
    private LoginPage loginPage;
    private MainPage mainPage;
    private UserSteps userSteps;
    private ProfilePage profilePage;


    @Before
    public void startBeforeEveryTest(){
        String pathYandex = "src/main/resources/yandexdriver.exe";
        String pathChrome = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathYandex);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);

        mainPage = open(MainPage.URL,MainPage.class);
        loginPage = page(LoginPage.class);
        user = UserDataGenerator.getUserCreateFaker();
        userSteps = new UserSteps();
        profilePage = page(ProfilePage.class);
    }
//    @After
//    public void clearDate(){

//    }
//    @AfterClass
//    public static void tearDown(){

//    }
public void startBrowser() {
    String pathYandex = "src/main/resources/yandexdriver.exe";
    String pathChrome = "src/main/resources/chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", pathYandex);
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--headless");
    WebDriver driver = new ChromeDriver(options);
    WebDriverRunner.setWebDriver(driver);
}
}