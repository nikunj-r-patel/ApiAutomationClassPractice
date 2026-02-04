package com.restAssured.SampleCheck.testNGExamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiTest013_TestNG_Priority {

    @Test(priority = 1)
    public void t1() {
        System.out.println("This is a test T1");
    }
    @Test(priority = 3)
    public void t2() {
        System.out.println("This is a test T3");
    }
    @Test(priority = 2)
    public void t3() {
        System.out.println("This is a test T2");
    }
}
