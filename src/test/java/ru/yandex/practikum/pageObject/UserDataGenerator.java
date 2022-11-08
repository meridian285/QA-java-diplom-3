package ru.yandex.practikum.pageObject;

import io.qameta.allure.Step;
import net.datafaker.Faker;

public class UserDataGenerator {
    private String name;
    private String email;
    private String password;

    public UserDataGenerator() {

    }

    @Step("Случайные данные для регистрации - email, password, name")
    public UserDataGenerator getUserCreateFaker() {
        Faker faker = new Faker();
        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        password = faker.random().hex(8);
        return getUserCreateFaker();
    }

    public UserDataGenerator(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
