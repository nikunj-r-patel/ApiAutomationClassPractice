package com.restAssured.SampleCheck.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ApiTest009_POST_nonBDD {
    // https://restful-booker.herokuapp.com/auth

    // -H 'Content-Type: application/json' \
    // -d '{
    //    "username" : "admin",
    //    "password" : "password123"
    //}'
    @Description("Verify the POST Req - BDD Style TC-001")
    @Test
    public void testing_POST_nonBDD_Style () {
        RequestSpecification req = RestAssured.given();
        String payLoad = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        req.baseUri("https://restful-booker.herokuapp.com");
                    req.basePath("/auth");
                    req.contentType(ContentType.JSON).log().all();
                    req.body(payLoad);
                req.when().log().all().post();
                req.then().log().all().statusCode(200);
    }



}
