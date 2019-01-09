package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = bufferedReader.readLine();
        String fileNameTwo = bufferedReader.readLine();
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileNameOne));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameTwo));

        while (bufferedReader.ready()) {
            String string = bufferedReader.readLine().replaceAll("[^a-zA-Z\\d\\s[\\n]]", "");
            bufferedWriter.write(string);
        }
        bufferedReader.close();
        bufferedWriter.close();

    }
}
