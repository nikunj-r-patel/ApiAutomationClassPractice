package com.restAssured.SampleCheck;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApiTest007_non_BDD_Style_GET {
     //RequestSpecification r = RestAssured.given();
     RequestSpecification r;

    @BeforeMethod
    public void setup() {
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
    }

     @Test
    public void test_GET_req_nonBDD_positive () {
//         String pin_code = "395005";
//        RequestSpecification req = RestAssured.given();
       //  r.baseUri("https://api.zippopotam.us");
         r.basePath("/in/395005");
         r.when().log().all().get();
         r.then().log().all().statusCode(200);

     }

    @Test
    public void test_GET_req_nonBDD_negative () {
//        String pin_code = "-1";
//       RequestSpecification req = RestAssured.given();
        //r.baseUri("https://api.zippopotam.us");
        r.basePath("/in/-1");
        r.when().log().all().get();
        r.then().log().all().statusCode(404);

    }
}
