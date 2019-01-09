package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream currentStream = new PrintStream(byteArrayOutputStream);
        PrintStream fileSteam = new PrintStream(new FileOutputStream(fileName));


        System.setOut(currentStream);

        testString.printSomething();
        String result = byteArrayOutputStream.toString();


        System.setOut(consoleStream);

        fileSteam.print(result);
        fileSteam.close();

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

