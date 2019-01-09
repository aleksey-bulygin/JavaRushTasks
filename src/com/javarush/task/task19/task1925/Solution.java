package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length != 0) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));


            StringBuffer stringBuffer = new StringBuffer("");
            while (bufferedReader.ready()) {
                String[] strings = bufferedReader.readLine().split(" ");
                for (String string : strings) {
                    if (string.length() > 6)
                        stringBuffer.append(string + ",");
                }
            }
            bufferedReader.close();

            bufferedWriter.write(stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length()).toString());
            bufferedWriter.close();

        }

    }
}
