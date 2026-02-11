package com.restAssured.SampleCheck.PayloadMangement;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.*;

public class ApiTest018_TestNG_Assertion_Payload_MAP {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;


    @Description(value = "Verify the POST request - nonBDD create booking TC1")
    @Test
    public void testing_POST_req_nonBDD_Create_MAP () {
        requestSpecification = RestAssured.given();
        String token= "b8d5e439dfaab0a";
        //   String bookingID = "3395";
//        String payloadPUT = "{\n" +
//                "    \"firstname\" : \"James1\",\n" +
//                "    \"lastname\" : \"Brown1\",\n" +
//                "    \"totalprice\" : 1111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";


        // JSON -> HashMAP by Gson/ jackson API
        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap();

        jsonBodyUsingMap.put("firstname", "James1");
        jsonBodyUsingMap.put("lastname", "Brown1");
        jsonBodyUsingMap.put("totalprice", 1111);
        jsonBodyUsingMap.put("depositpaid", true);
        jsonBodyUsingMap.put("additionalneeds","Breakfast");

        Map<String, String > bookingDatesMap = new LinkedHashMap();
        bookingDatesMap.put("checkin", "2026-01-01");
        bookingDatesMap.put("checkout", "2026-01-10");
        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);

        // MAP-> JSON
        /*Booking booking = new Booking();
        booking.setFirstName("James1");
        booking.setLastName("Smith");
        booking.setTotalprice(1110);
        booking.setDepositpaid(true);


        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2026-02-01");
        bookingDates.setCheckout("2026-02-02");
        booking.setBookingdates(bookingDates);

        booking.setAdditionalneeds("lunch 01");*/


        //System.out.println(booking);

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"/*+bookingID*/);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(jsonBodyUsingMap).log().all();
        Response response= requestSpecification.when().log().all().post();
        ValidatableResponse validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);
       // System.out.println("booking ====> "+booking.toString());
        //System.out.println(" bookingDates ====>"+bookingDates.toString());
        System.out.println("the booking id is =====>"+(response.then().extract().path("bookingid")));

    }
}
