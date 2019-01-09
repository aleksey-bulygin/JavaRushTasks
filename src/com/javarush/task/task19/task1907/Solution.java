package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        FileReader fileReader = new FileReader(fileName);
        StringBuffer stringBuffer = new StringBuffer("");

        while (fileReader.ready())
            stringBuffer.append((char) fileReader.read());
        String[] lineCheck = stringBuffer.toString().split("\\bworld\\b");
        fileReader.close();

        System.out.println(lineCheck.length - 1);



    }
}
