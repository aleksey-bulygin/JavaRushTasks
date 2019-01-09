package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne, fileNameTwo;

        fileNameOne = bufferedReader.readLine();
        fileNameTwo = bufferedReader.readLine();
        bufferedReader.close();

        allLines = Files.readAllLines(Paths.get(fileNameOne));
        forRemoveLines = Files.readAllLines(Paths.get(fileNameTwo));

        new Solution().joinData();


    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }


}
