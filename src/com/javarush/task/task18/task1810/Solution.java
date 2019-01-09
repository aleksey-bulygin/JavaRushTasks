package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = null;
        StringBuffer fileName;

        while (true) {
            fileName = new StringBuffer(bufferedReader.readLine());

            fileInputStream = new FileInputStream(fileName.toString());

            byte[] bytesFromFile = new byte[fileInputStream.available()];
            fileInputStream.read(bytesFromFile);

            if (bytesFromFile.length < 1000) {
                bufferedReader.close();
                fileInputStream.close();
                throw new DownloadException();
            }

        }

    }

    public static class DownloadException extends Exception {

    }
}
