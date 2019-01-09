package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<char[]> lineChecks = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = bufferedReader.readLine();
        String fileNameTwo = bufferedReader.readLine();
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileNameOne));
        while (bufferedReader.ready())
            lineChecks.add(bufferedReader.readLine().toCharArray());
        bufferedReader.close();

        replaceDot(lineChecks);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameTwo));
        for (int i = 0; i < lineChecks.size(); i++){
            for (char ch : lineChecks.get(i))
                    bufferedWriter.write(ch);
        }
        bufferedWriter.close();
    }

    public static void replaceDot(ArrayList<char[]> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(i).length; j++)
                if (arrayList.get(i)[j] == '.')
                    arrayList.get(i)[j] = '!';
        }
    }
}
