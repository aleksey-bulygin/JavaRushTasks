package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = bufferedReader.readLine();
        String fileNameTwo = bufferedReader.readLine();
        String fileNameThree = bufferedReader.readLine();

        bufferedReader.close();

        FileInputStream fileInputStream = new FileInputStream(fileNameOne);
        FileOutputStream fileOutputStreamFileTwo = new FileOutputStream(fileNameTwo);
        FileOutputStream fileOutputStreamFileThree = new FileOutputStream(fileNameThree);


        int counBytes = (fileInputStream.available() % 2 == 0) ? fileInputStream.available() / 2 : (fileInputStream.available() / 2) + 1;

        byte[] bytesForFileTwo = new byte[counBytes];
        byte[] bytesForFileThree = new byte[fileInputStream.available() - counBytes];

        fileInputStream.read(bytesForFileTwo);
        fileInputStream.read(bytesForFileThree);

        fileOutputStreamFileTwo.write(bytesForFileTwo);
        fileOutputStreamFileThree.write(bytesForFileThree);

        fileInputStream.close();
        fileOutputStreamFileTwo.close();
        fileOutputStreamFileThree.close();



    }
}
