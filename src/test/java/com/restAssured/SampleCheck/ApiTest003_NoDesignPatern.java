    package com.restAssured.SampleCheck;

import io.restassured.RestAssured;

public class ApiTest003_NoDesignPatern {
    public void step1(){
        System.out.println("Step 1 ");
    }
    public void step2(){
        System.out.println("Step 2 ");
    }
    public void step3(String param1){
        System.out.println(param1 );
    }
    public static void main(String[] args) {
    ApiTest003_NoDesignPatern np = new ApiTest003_NoDesignPatern();
    np.step1();
    np.step2();
    np.step3("nikunj");

    }
}
