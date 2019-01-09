package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String filename = bufferedReader.readLine();
        bufferedReader.close();

        InputStream inputStream = new FileInputStream(filename);
        BufferedInputStream bf = new BufferedInputStream(inputStream);

        while (bf.available() > 0)
        {
            char c = (char) bf.read();
            System.out.print(c);
        }

        inputStream.close();
        bf.close();


    }
}