package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {

        int[] n = countBackSpaceInFile(args[0]);

        System.out.println( String.format("%.2f", n[0] * 1.0 / n[1] * 100));

    }

    private static int[] countBackSpaceInFile(String fileName) throws IOException {
        int counBackSpace = 0;

        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] bytesOfFile = new byte[fileInputStream.available()];
        fileInputStream.read(bytesOfFile);
        fileInputStream.close();

        for (int byteOfFile : bytesOfFile) {
                if ( (char) byteOfFile == ' ')
                    counBackSpace++;
        }


        int[] result = {counBackSpace, bytesOfFile.length};

        return result;
    }

}
