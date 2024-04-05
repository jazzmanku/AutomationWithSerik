package com.tat;

public class Main {
    public static void MyFancyMethod(){
        System.out.println("Hello world!");
    }
    public static int ComplexFinancialMethod(int a, int b){
        return (2*a+3*b)*(3*a);
    }
    public static double ComplexFinancialMethod(double x, double y){
        double c = Math.round((2*x+3*y)*(3*x));
        return c;
    }
}