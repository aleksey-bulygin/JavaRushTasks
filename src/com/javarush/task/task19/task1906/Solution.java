package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = bufferedReader.readLine();
        String fileNameTwo = bufferedReader.readLine();
        bufferedReader.close();

        FileReader fileReader = new FileReader(fileNameOne);
        FileWriter fileWriter = new FileWriter(fileNameTwo);

        while (fileReader.ready()) {
            fileReader.read();
            char ch = (char) fileReader.read();
            fileWriter.write(ch);
        }
        fileReader.close();
        fileWriter.close();

    }
}
