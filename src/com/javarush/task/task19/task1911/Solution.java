package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
     //   TestString testString = new TestString();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream currentStream = new PrintStream(byteArrayOutputStream);

        System.setOut(currentStream);

        testString.printSomething();

        String result = byteArrayOutputStream.toString();
        result = result.toUpperCase();

        System.setOut(consoleStream);

        System.out.println(result);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
