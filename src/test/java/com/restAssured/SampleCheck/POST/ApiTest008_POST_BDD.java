package com.restAssured.SampleCheck.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class ApiTest008_POST_BDD {
    // https://restful-booker.herokuapp.com/auth

    // -H 'Content-Type: application/json' \
    // -d '{
    //    "username" : "admin",
    //    "password" : "password123"
    //}'
    @Description("Verify the POST Req - BDD Style TC-001")
    @Test
    public void testing_POST_BDD_Style () {
        String payLoad = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON)
                    .log().all().body(payLoad)
                .when().log().all().post()
                .then().log().all().statusCode(200);
    }



}
