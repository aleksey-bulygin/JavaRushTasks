package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> bytesOfFile = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = bufferedReader.readLine();
        String fileTwo = bufferedReader.readLine();
        String fileThree = bufferedReader.readLine();
        bufferedReader.close();

        FileOutputStream outputStreamFileOne = new FileOutputStream(fileOne);
        FileInputStream inputStreamFileTwo = new FileInputStream(fileTwo);
        FileInputStream inputStreamFileThree = new FileInputStream(fileThree);

        while (inputStreamFileTwo.available() > 0)
            bytesOfFile.add(inputStreamFileTwo.read());
        inputStreamFileTwo.close();

        while (inputStreamFileThree.available() > 0)
            bytesOfFile.add(inputStreamFileThree.read());
        inputStreamFileThree.close();

        for (int outputByte : bytesOfFile)
            outputStreamFileOne.write(outputByte);
        outputStreamFileOne.close();


    }
}
