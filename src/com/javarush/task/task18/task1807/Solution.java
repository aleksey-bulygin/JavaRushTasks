package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         String fileName = bufferedReader.readLine();
         bufferedReader.close();

        int needCharCount = 0;
        FileInputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() > 0)
        {
            int tmpCode = fileInputStream.read();
            if (tmpCode == 44)
                needCharCount++;

        }

        System.out.println(needCharCount);
        fileInputStream.close();
    }
}
