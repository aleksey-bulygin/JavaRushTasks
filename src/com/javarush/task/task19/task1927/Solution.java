package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
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
        String[] tmpLines = byteArrayOutputStream.toString().split("\n");
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < tmpLines.length; i++) {
            stringBuffer.append(tmpLines[i] + "\n");
            if (i % 2 != 0)
                stringBuffer.append("JavaRush - курсы Java онлайн" + "\n");
        }

        System.setOut(consoleStream);
        System.out.println(stringBuffer.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
