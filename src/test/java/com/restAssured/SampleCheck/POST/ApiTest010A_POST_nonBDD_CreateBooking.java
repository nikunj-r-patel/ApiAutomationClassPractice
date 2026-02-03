package com.restAssured.SampleCheck.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ApiTest010A_POST_nonBDD_CreateBooking {
        //    curl -X POST \
        //    https://restful-booker.herokuapp.com/booking \
        //            -H 'Content-Type: application/json' \
        //            -d '{
        //            "firstname" : "Jim",
        //            "lastname" : "Brown",
        //            "totalprice" : 111,
        //            "depositpaid" : true,
        //            "bookingdates" : {
        //        "checkin" : "2018-01-01",
        //                "checkout" : "2019-01-01"
        //    },
        //            "additionalneeds" : "Breakfast"
        //}'

    //"token": "0b874d3ae1b4a96"

    @Description(value = "Verify the POST request - nonBDD create booking TC1")
    @Test
    public void testing_POST_req_nonBDD_Create () {
        RequestSpecification req = RestAssured.given();
        String token= "b8d5e439dfaab0a";
     //   String bookingID = "3395";
        String payloadPUT = "{\n" +
                "    \"firstname\" : \"James1\",\n" +
                "    \"lastname\" : \"Brown1\",\n" +
                "    \"totalprice\" : 1111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/"/*+bookingID*/);
        req.contentType(ContentType.JSON);
        req.cookie("token",token);
        req.body(payloadPUT).log().all();
//        req.when().log().all().post();
//        req.then().log().all().statusCode(200);
        Response response= req.when().log().all().post();
        ValidatableResponse validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);

    }
}
