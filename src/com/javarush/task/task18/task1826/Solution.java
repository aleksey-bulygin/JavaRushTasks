package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        cryptMain(args);
    }

    public static void cryptMain(String[] args) throws IOException {
        String fileName;
        String fileOutputName;
        byte[] bytesFromFile;

        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        switch (args[0]) {

            case "-e" :
                fileName = args[1];
                fileOutputName = args[2];

                fileInputStream = new FileInputStream(fileName);
                bytesFromFile = new byte[fileInputStream.available()];
                fileInputStream.read(bytesFromFile);
                fileInputStream.read();
                fileInputStream.close();

                fileOutputStream = new FileOutputStream(fileOutputName);
              //  fileOutputStream.write(crypt(bytesFromFile));

                for (byte b : bytesFromFile)
                    fileOutputStream.write(b + 1);
                fileOutputStream.close();
                break;

            case "-d" :
                fileName = args[1];
                fileOutputName = args[2];

                fileInputStream = new FileInputStream(fileName);
                bytesFromFile = new byte[fileInputStream.available()];
                fileInputStream.read(bytesFromFile);
                fileInputStream.read();
                fileInputStream.close();

                fileOutputStream = new FileOutputStream(fileOutputName);
             //   fileOutputStream.write(encrypt(bytesFromFile));
                for (byte b : bytesFromFile)
                    fileOutputStream.write(b - 1);

                fileOutputStream.close();
                break;

        }
    }

    public static byte[] crypt(byte[] bytes) {
        byte[] newBytes = new byte[bytes.length];

        for (int i = 0; i < bytes.length; i++)
            newBytes[i] =  bytes[i];

        return newBytes;
    }

    public static byte[] encrypt(byte[] bytes) {
        byte[] newBytes = new byte[bytes.length];

        for (int i = 0; i < bytes.length; i++)
            newBytes[i] = bytes[i];

        return newBytes;
    }

}
