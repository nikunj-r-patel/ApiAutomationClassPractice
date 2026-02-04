package com.restAssured.SampleCheck.testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest017_TestNG_invocationCount {
    @Test(invocationCount = 5)
    public void t1() {
        System.out.println("This is a test T1");
        Assert.assertTrue(true);
    }
    @Test(enabled = false)
    public void t2() {
        System.out.println("This is a test T2");
    }
    @Test(alwaysRun = true)
    public void t3() {
        System.out.println("This is a test T3");
    }
}
