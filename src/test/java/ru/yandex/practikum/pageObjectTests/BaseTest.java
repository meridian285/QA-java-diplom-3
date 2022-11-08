package ru.yandex.practikum.pageObjectTests;


import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.open;

public abstract class  BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void startBeforeEveryTest(){

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.get("https://stellarburgers.nomoreparties.site/");
//        Configuration.browser = CHROME;

        open("https://stellarburgers.nomoreparties.site");
    }
//    @After
//    public void clearDate(){
//        driver.manage().deleteAllCookies();
//        ((WebStorage) driver).getLocalStorage().clear();
//        ((WebStorage) driver).getSessionStorage().clear();
//    }
//    @AfterClass
//    public static void tearDown(){
//        driver.quit();
//    }
}