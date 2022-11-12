package ru.yandex.practikum.pageObject.api.steps;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestClient {

    private final static String URL = "https://stellarburgers.nomoreparties.site/";

    public static String getBaseUri() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";

        return URL;
    }

    public RequestSpecification getDefaultRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(getBaseUri())
                .setContentType(ContentType.JSON)
                .build();
    }
}