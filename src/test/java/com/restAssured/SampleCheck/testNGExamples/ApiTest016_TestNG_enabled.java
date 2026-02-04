package com.restAssured.SampleCheck.testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ApiTest016_TestNG_enabled {
    @Test
    public void t1() {
        System.out.println("This is a test T1");
        Assert.assertTrue(false);
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
