package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {


    public static void main(String[] args) throws IOException {


        System.out.println(countWordEnglishAlpabhet(args[0]));
    }

    private static int countWordEnglishAlpabhet(String fileName) throws IOException {
        int counWords = 0;
        String string = "abcdefghijklmnopqrstuvwxyz" + "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        char[] alpabhet = string.toCharArray();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] bytesOfFile = new byte[fileInputStream.available()];
        fileInputStream.read(bytesOfFile);
        fileInputStream.close();

        for (int byteOfFile : bytesOfFile) {
            for (int i = 0; i < alpabhet.length; i++) {
                if ( (char) byteOfFile == alpabhet[i] )
                    counWords++;
            }
        }


        return counWords;
    }
}
