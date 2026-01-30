package com.restAssured.SampleCheck;

import io.restassured.RestAssured;

public class ApiTest002 {
    public static void main(String[] args) {
        // Gherkins  Syntaxt
        // Full URL = https://restful-booker.herokuapp.com/booking/1
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("/booking/1")
                   .when().get()
                   .then().log().all().statusCode(200);

    }
}
