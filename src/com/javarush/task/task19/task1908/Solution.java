package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String[]> lineChecks = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = bufferedReader.readLine();
        String fileNameTwo = bufferedReader.readLine();
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileNameOne));
        while (bufferedReader.ready())
            lineChecks.add(bufferedReader.readLine().split(" "));
        bufferedReader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameTwo));
        for (int i = 0; i < lineChecks.size(); i++){
            for (String string : lineChecks.get(i))
                if (isParse(string))
                    bufferedWriter.write(string + " ");
        }
        bufferedWriter.close();

    }

    public static boolean isParse(String checkString) {
        boolean isParse = true;

        try {
            Integer.valueOf(checkString);
        } catch (NumberFormatException e)
        {
            isParse = false;
        }

        return isParse;
    }
}
