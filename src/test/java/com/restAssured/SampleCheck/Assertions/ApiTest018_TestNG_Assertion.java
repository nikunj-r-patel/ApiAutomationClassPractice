package com.restAssured.SampleCheck.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ApiTest018_TestNG_Assertion {
   /* @Test
     public void test_hardAssertion () {


        System.out.println("Start test hardAssertion 000001");
        Assert.assertTrue(false);
        System.out.println(" end test_hardAssertion 00000X");
    }*/
    @Test
    public void test_softAssertion () {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Start test softAssertion 000001");
        softAssert.assertTrue(false);
        System.out.println(" end test softAssertion 00000X");
        softAssert.assertAll();
    }
}

