package com.restAssured.SampleCheck.testNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ApiTest015_TestNG_Parameter {
    @Parameters("browser")
    @Test
    void demo1(String value) {
        System.out.println("This is a test NG_PARAMETER browser is " + value);
        if (value.equalsIgnoreCase("chrome")) {
            System.out.println("Start the browser chrome");
        }
        else if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start the browser firefox");
        }
    }
}
