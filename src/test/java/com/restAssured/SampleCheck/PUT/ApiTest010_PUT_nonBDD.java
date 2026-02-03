package com.restAssured.SampleCheck.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ApiTest010_PUT_nonBDD {
    //    curl -X PUT \
    //    https://restful-booker.herokuapp.com/booking/1 \
    //            -H 'Content-Type: application/json' \
    //            -H 'Accept: application/json' \
    //            -H 'Cookie: token=abc123' \
    //            -d '{
    //            "firstname" : "James",
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

    @Description(value = "Verify the PUT request - nonBDD TC1")
    @Test
    public void testing_PUT_req_BDD () {
        RequestSpecification req = RestAssured.given();
        String token= "b8d5e439dfaab0a  ";
        String bookingID = "3395";
        String payloadPUT = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/"+bookingID);
        req.contentType(ContentType.JSON);
        req.cookie("token",token);
        req.body(payloadPUT).log().all();

        Response response= req.when().log().all().put();
        ValidatableResponse validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);





    }
}
