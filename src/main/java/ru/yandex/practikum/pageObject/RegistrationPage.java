package ru.yandex.practikum.pageObject;

import org.openqa.selenium.By;

public class RegistrationPage {
    private By mailField = By.xpath("//*[@class = 'input__container']//*[text()='Email']");
    private By passwordField = By.xpath("//*[@class = 'input__container']//*[text()='Email']");
    private By registrationLink = By.xpath("//*[@href='/register']");
    private By restorePasswordLink = By.xpath("//*[@href='/forgot-password']");
}
