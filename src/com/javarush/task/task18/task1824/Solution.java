package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String filename = bufferedReader.readLine();

            try {
                FileInputStream fileInputStream = new FileInputStream(filename);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(filename);
                break;
            }
        }


    }
}


