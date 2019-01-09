package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<StringBuffer> dataFromFile = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()) {
            String dataLine = bufferedReader.readLine();
            dataFromFile.add(new StringBuffer(dataLine));
        }
        bufferedReader.close();

        for (StringBuffer stringBuffer : dataFromFile)
            System.out.println(stringBuffer.reverse().toString());
    }
}
