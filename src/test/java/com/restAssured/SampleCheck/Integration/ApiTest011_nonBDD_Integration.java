package com.restAssured.SampleCheck.Integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

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
       String payloadPOST = "{\n" +
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
        requestSpecification.body(payloadPOST).log().all();
        Response response= requestSpecification.when().post();
        ValidatableResponse validatableResponse= response.then();
        validatableResponse.statusCode(200);
        bookingID = response.jsonPath().getString("bookingid");
        return bookingID;
    }
    @Test(priority=1)
    public void test_Update_booking () {
        token= getToken();
        bookingID = getBookingID();
//        System.out.println("testing getBokking ID is _________>>>>>>> "+ bookingID);
//        System.out.println("testing getToken  is _________>>>>>>> "+ token);
        String payloadPUT = "{\n" +
                "    \"firstname\" : \"James3\",\n" +
                "    \"lastname\" : \"Brown3\",\n" +
                "    \"totalprice\" : 1113,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch3\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();
        Response response= requestSpecification.when().put();
        ValidatableResponse validatableResponse= response.then();
        validatableResponse.statusCode(200);
        System.out.println("the updated booking id is =====>"+bookingID);
        System.out.println("this updaed details are  ======> "+ requestSpecification.when().put().asPrettyString());
    }
    @Test(priority=2)
    public void test_get_booking () {
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
       /* requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
       // requestSpecification.body(payloadPUT).log().all();
        Response response= requestSpecification.when().get();
        ValidatableResponse validatableResponse= response.then();
        validatableResponse.statusCode(200);
        String bookingBody = response.jsonPath().prettify();*/
        requestSpecification.when().get();
        requestSpecification.then().log().all().statusCode(200);
        System.out.println("this is booking we get is  ======>"+ bookingID);
        System.out.println("this is get details ======> "+ (requestSpecification.when().get().asPrettyString()));


    }
    @Test(priority=3)
    public void test_delete_booking () {
        requestSpecification=RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        // requestSpecification.body(payloadPUT).log().all();
        response= requestSpecification.when().delete();
        ValidatableResponse validatableResponse= response.then();
        validatableResponse.statusCode(201);
        System.out.println("the deleted booking is =====>"+ bookingID);

    }
    @Test(priority=4)
    public void test_verify_deleted_booking () {
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        // requestSpecification.body(payloadPUT).log().all();
        Response response= requestSpecification.when().get();
        ValidatableResponse validatableResponse= response.then();
        validatableResponse.statusCode(404);

        System.out.println("the after deleted booking was not found  =====>"+ bookingID);
    }

}
