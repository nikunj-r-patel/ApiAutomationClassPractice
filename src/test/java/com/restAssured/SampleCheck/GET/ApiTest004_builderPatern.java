    package com.restAssured.SampleCheck.GET;

    public class ApiTest004_builderPatern {
        public ApiTest004_builderPatern step1() {
            System.out.println("Step1 start");
            System.out.println("Step1 Exit");
            return this;
        }
        public ApiTest004_builderPatern step2() {
            System.out.println("Step2 start");
            System.out.println("Step2 Exit");
            return this;
        }
        public ApiTest004_builderPatern step3(String name) {
            System.out.println("Step3 start");
            System.out.println("Step3 Exit"+"->"+ name);
            return this;
        }

        public static void main(String[] args) {
            ApiTest004_builderPatern bp = new ApiTest004_builderPatern();
            bp.step1().step2().step3("nikunj2");
        }
    }
