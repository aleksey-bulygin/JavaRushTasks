package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream currentStream = new PrintStream(byteArrayOutputStream);

        System.setOut(currentStream);

        testString.printSomething();
        String checkLines[] = byteArrayOutputStream.toString().split(" ");
        int a = Integer.parseInt(checkLines[0]);
        int b = Integer.parseInt(checkLines[2]);
        int c = 0;
        switch (checkLines[1]) {
            case "+" :
                c = a + b;
                break;
            case "-" :
                c = a - b;
                break;
            case "*" :
                c = a * b;
                break;
        }
        String result = a + " " + checkLines[1] + " " + b + " " + checkLines[3] + " " + c;

        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

