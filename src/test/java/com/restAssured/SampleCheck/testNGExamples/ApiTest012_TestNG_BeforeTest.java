package com.restAssured.SampleCheck.testNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiTest012_TestNG_BeforeTest {


    @BeforeTest
    public void TestNG_BeforeTest() {
        System.out.println("This is a test NG_BeforeTest 000001");
    }
    @Test
    public void TestNG_BeforeTest_NonBDD_Integral() {
        System.out.println("This is a test NG_BeforeTest_NonBDD_Integral");
    }
    @Test(dependsOnMethods = "TestNG_BeforeTest_NonBDD_Integral" )
    public void TestNG_AfterTest() {
        System.out.println("This is a test NG_AfterTest");
    }
    @BeforeTest
    public void getToken() {
        System.out.println("This is a test NG_getToken 00000002");
    }
    @BeforeTest
    public  void getBookingID() {
        System.out.println("This is a test NG_getBookingID 00000003");
    }
    @Test
    public void TestNG_test_PUT_BookingID() {

        System.out.println("This is a test NG_test_PUT_BookingID");
    }
}
