package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = bufferedReader.readLine();
        String fileNameTwo = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream fileInputStream = new FileInputStream(fileNameOne);
        FileOutputStream fileOutputStream = new FileOutputStream(fileNameTwo);

        byte[] bytesFromFileOne = new byte[fileInputStream.available()];
        fileInputStream.read(bytesFromFileOne);

        for (int i = bytesFromFileOne.length - 1; i >= 0; i--) {
            fileOutputStream.write(bytesFromFileOne[i]);
        }

        fileInputStream.close();
        fileOutputStream.close();

    }
}
