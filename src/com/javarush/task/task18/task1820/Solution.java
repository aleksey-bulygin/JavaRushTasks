package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = bufferedReader.readLine();
        String fileTwo = bufferedReader.readLine();
        bufferedReader.close();


        bufferedReader = new BufferedReader(new FileReader(fileOne));
        StringBuffer stringBufferFileOne = new StringBuffer();

        while (bufferedReader.ready())
            stringBufferFileOne.append(bufferedReader.readLine());
        bufferedReader.close();

        String[] stringsFileOne = stringBufferFileOne.toString().split(" ");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTwo));
        for (String stringNumber : stringsFileOne)
            bufferedWriter.write((int) Math.round(Float.parseFloat(stringNumber)) + " ");

        bufferedWriter.close();
    }
}
