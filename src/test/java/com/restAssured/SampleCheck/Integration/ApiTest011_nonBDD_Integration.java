package com.restAssured.SampleCheck.Integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ApiTest011_nonBDD_Integration {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    String bookingID;
    public String getToken () {

        String payLoad = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(payLoad);
       Response  response =  requestSpecification.when().post();
       ValidatableResponse validatableResponse = response.then();
       validatableResponse.statusCode(200);
       token = response.jsonPath().getString("token");

        return token;
    }
   /* @Test
    public void test_create_booking () {
        token= getToken();
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
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"*//*+bookingID*//*);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();
        Response response= requestSpecification.when().post();
        ValidatableResponse validatableResponse= response.then();
        validatableResponse.statusCode(200);
        bookingID = response.jsonPath().getString("bookingid");
    }*/
    public String getBookingID () {
        String token= getToken();
       String payloadPUT = "{\n" +
                "    \"firstname\" : \"James2\",\n" +
                "    \"lastname\" : \"Brown2\",\n" +
                "    \"totalprice\" : 1112,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"/*+bookingID*/);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();
        Response response= requestSpecification.when().post();
        ValidatableResponse validatableResponse= response.then();
        validatableResponse.statusCode(200);
        bookingID = response.jsonPath().getString("bookingid");
        return bookingID;
    }
    @Test
    public void test_Update_booking () {
        String token= getToken();
        String bookingID = getBookingID();
//        System.out.println("testing getBokking ID is _________>>>>>>> "+ bookingID);
//        System.out.println("testing getToken  is _________>>>>>>> "+ token);
    }
    @Test
    public void test_get_booking () {

    }
    @Test
    public void test_delete_booking () {

    }
    @Test
    public void test_verify_deleted_booking () {

    }

}
