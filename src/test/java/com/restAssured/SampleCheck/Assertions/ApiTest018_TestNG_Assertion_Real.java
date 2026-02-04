package com.restAssured.SampleCheck.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.hamcrest.Matchers;
import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiTest018_TestNG_Assertion_Real {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token ;
    Integer bookingID;
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
    @Test
    public void test_Post_req_with_assertion() {

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
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"/*+bookingID*/);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPOST).log().all();
        response= requestSpecification.when().post();
        validatableResponse= response.then();
        validatableResponse.statusCode(200);

        /*------------------------------------------------------------------------------------*/
        // Validatable response- 1 Hamcrest- Rest Assured
            // import org.hamcrest.Matchers;
        validatableResponse.body("booking.firstname", Matchers.equalTo("James2"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Brown2"));
        //validatableResponse.body("booking.totalprice", Matchers.equalTo("1112"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        //validatableResponse.body("booking.bookingdates", Matchers.equalTo("2019-01-01"));
        validatableResponse.body("booking.bookingid", Matchers.nullValue());
        System.out.println(" the result of the validatable Hamcrest matcher is "+ response.getStatusCode());

        /*------------------------------------------------------------------------------------*/
        // TestNG Assertion-2
            // hard and soft assertion
        bookingID = response.then().extract().path("bookingid");
        System.out.println("bookingID =====> " + bookingID);
        String firstName= response.then().extract().path("booking.firstname");
        String lastName= response.then().extract().path("booking.lastname");
        Assert.assertEquals(firstName,"James2");
        Assert.assertEquals(lastName,"Brown2");
        Assert.assertNotNull(bookingID);
        System.out.println("the result of testNG assert is "+ response.getStatusCode());
        /*------------------------------------------------------------------------------------*/
        // AssertJ 3rd party Lib  to Assertion-3
            // add dependencies in pom.xml
                //            <!-- Source: https://mvnrepository.com/artifact/org.assertj/assertj-core -->
                //                <dependency>
                //                 <groupId>org.assertj</groupId>
                //                    <artifactId>assertj-core</artifactId>
                //                    <version>4.0.0-M1</version>
                //                 <scope>test</scope>
                //                </dependency>
            // import static org.assertj.core.api.Assertions.*;
        Integer bookingID2 = response.then().extract().path("bookingid");
        System.out.println("bookingID2 =====> " + bookingID2);
        System.out.println("bookingID in assertJ=====>"+ bookingID);
        assertThat(bookingID).isNotNull().isPositive().isNotZero();
        assertThat(bookingID).isEqualTo(bookingID2);
        assertThat(firstName).isEqualTo("James2").isNotBlank().isNotEmpty().isNotNull().isAlphanumeric();
        assertThat(lastName).isEqualTo("Brown2").isNotBlank().isNotEmpty().isNotNull().isAlphanumeric();
        System.out.println("the result of assertJ is "+ response.getStatusCode());
        /*------------------------------------------------------------------------------------*/



    }

}

