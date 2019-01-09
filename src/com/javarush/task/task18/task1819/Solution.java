package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = bufferedReader.readLine();
        String fileTwo = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream fileInputStream;
        byte[] buffOne;
        byte[] buffTwo;

        fileInputStream = new FileInputStream(fileOne);
        buffOne = new byte[fileInputStream.available()];
        fileInputStream.read(buffOne);
        fileInputStream.close();

        fileInputStream = new FileInputStream(fileTwo);
        buffTwo = new byte[fileInputStream.available()];
        fileInputStream.read(buffTwo);
        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileOne);
        fileOutputStream.write(buffTwo);
        fileOutputStream.write(buffOne);

        fileOutputStream.close();


    }
}
