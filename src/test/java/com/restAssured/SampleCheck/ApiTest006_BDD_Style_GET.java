package com.restAssured.SampleCheck;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class ApiTest006_BDD_Style_GET {

     @Test
    public void test_GET_req_positive () {
         String pin_code = "395005";
         RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/in/"+pin_code)
                 .when().log().all().get()
                 .then().statusCode(200);
     }

    @Test
    public void test_GET_req_negative () {
        String pin_code = "-1";
        RestAssured.given().baseUri("https://api.zippopotam.us").basePath("/in/"+pin_code)
                .when().log().all().get()
                .then().statusCode(404);
    }
}
