package com.restAssured.SampleCheck.testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest014_TestNG_Groups {

    @Test(groups={"stage","qa","prd"} )
    public void smoke() {
        System.out.println("This is a test smoke \"stage\",\"qa\",\"prd\"");
        Assert.assertTrue(true);
    }
    @Test(groups={"stage","prd"} )
    public void sanity() {
        System.out.println("This is a test sanity \"stage\",\"prd\"");
        Assert.assertTrue(true);
    }
    @Test(groups={"qa","prd"} )
    public void explo() {
        System.out.println("This is a test exploration \"qa\",\"prd\"");
        Assert.assertTrue(true);
    }
    @Test(groups={"stage","qa","prd"} )
    public void reg() {
        System.out.println("This is a test regression \"stage\",\"qa\",\"prd\"");
        Assert.assertTrue(true);
    }
    @Test(groups={"prd"} )
    public void uat() {
        System.out.println("This is a test user acceptance test \"prd\" ");
        Assert.assertTrue(true);
    }
}
