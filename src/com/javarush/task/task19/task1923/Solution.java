package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String[]> linesFromFileOne = new ArrayList<>();
        ArrayList<String> linesForFileTwo = new ArrayList<>();

        if (args.length != 0) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        //    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
            FileWriter fileWriter = new FileWriter(args[1]);

            while (bufferedReader.ready())
                linesFromFileOne.add(bufferedReader.readLine().split(" "));
            bufferedReader.close();

            for (int i = 0; i < linesFromFileOne.size(); i++) {
                StringBuffer stringBuffer = new StringBuffer("");

                for (String string : linesFromFileOne.get(i))
                    if (isValid(string))
                        stringBuffer.append(string + " ");

                linesForFileTwo.add(i, stringBuffer.toString());
            }

            for (String string : linesForFileTwo) {
                char[] chars = string.toCharArray();
                fileWriter.write(chars);
            }
            fileWriter.close();

        }
    }

    public static boolean isValid(String s) {
        String n = ".*[0-9].*";
        //String a = ".*[A-Z].*";
        return s.matches(n);
    }
}
