package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {

    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;



    public static void main(String[] args) {

        Solution mySolution = new Solution();

        System.out.println(mySolution.intVar);
        System.out.println(mySolution.doubleVar);
        System.out.println(mySolution.DoubleVar);
        System.out.println(mySolution.booleanVar);
        System.out.println(mySolution.ObjectVar);
        System.out.println(mySolution.ExceptionVar);
        System.out.println(mySolution.StringVar);
    }
}
