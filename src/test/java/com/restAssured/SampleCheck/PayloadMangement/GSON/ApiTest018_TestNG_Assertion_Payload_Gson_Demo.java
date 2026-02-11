package com.restAssured.SampleCheck.PayloadMangement.GSON;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class ApiTest018_TestNG_Assertion_Payload_Gson_Demo {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void test_Positive() {
        requestSpecification = RestAssured.given();
        String token= "b8d5e439dfaab0a";
        // Step1 - POST
        // URL -> Base URI + base Path
        // HEADER
        // BODY
        // Auth - NO


        // Step 2
        // prepare the Payload ( Object -> JSON String)
        // send the request

        //Step 3
        // Validate Response ( JSON String -> Object)
        // FirstName,
        // Status Code
        // Time Response
        Booking booking = new Booking();
        booking.setFirstname("A.James1111");
        booking.setLastname("Brown1111");
        booking.setTotalprice(2220);
        booking.setDepositpaid(true);


        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2026-02-11");
        bookingDates.setCheckout("2026-02-17");
        booking.setBookingdates(bookingDates);

        booking.setAdditionalneeds("Diner 03");


        System.out.println(booking);

        Gson gson = new Gson();
        // Object -> JSON String (GSON)
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"/*+bookingID*/);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(jsonStringBooking).log().all();
        Response response= requestSpecification.when().log().all().post();
        ValidatableResponse validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("***************************************************************");
        System.out.println("booking ====> "+booking.toString());
        System.out.println(" bookingDates ====>"+bookingDates.toString());
        System.out.println("the booking id is =====>"+(response.then().extract().path("bookingid")));

        String jsonStringResponse = response.asString();

        // Case1 - extract(), jsonPath().getString() - Response is small


        // Case 2- Response -> Compex JSON  - Huge JSON

        // String - Object  - De Ser

        BookingResponse bookingResponse = gson.fromJson(jsonStringResponse, BookingResponse.class);
        assertThat(bookingResponse.getBooking()).isNotNull().isNotNull();
        assertThat(bookingResponse.getBookingid()).isNotNull().isNotZero().isPositive();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("A.James1111").isNotNull().isNotEmpty().isNotBlank();
        assertThat(bookingResponse.getBooking().getLastname()).isEqualTo("Brown1111");
        assertThat(bookingResponse.getBooking().getTotalprice()).isEqualTo(2220);
        assertThat(bookingResponse.getBooking().getDepositpaid()).isEqualTo(true);
        assertThat(bookingResponse.getBooking().getAdditionalneeds()).isEqualTo("Diner 03");
        System.out.println("***************************************************************");
        System.out.println("bookingResponse ====> "+bookingResponse.getBooking().toString());
        System.out.println("bookingResponse  bookingDates ====>"+bookingResponse.getBooking().getBookingdates().toString());
        System.out.println("the bookingResponse  booking id is =====>"+bookingResponse.getBookingid());



    }
}
