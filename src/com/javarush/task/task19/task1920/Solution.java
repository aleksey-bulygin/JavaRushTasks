package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> peoplesMap = new TreeMap<>();

        if (args.length != 0) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

            while (bufferedReader.ready()) {
                String[] tmpLines = bufferedReader.readLine().split(" ");
                if (peoplesMap.containsKey(tmpLines[0]))
                    peoplesMap.put(tmpLines[0], peoplesMap.get(tmpLines[0]) + Double.parseDouble(tmpLines[tmpLines.length - 1]));
                else
                    peoplesMap.put(tmpLines[0], Double.parseDouble(tmpLines[tmpLines.length - 1]));
            }

            bufferedReader.close();

            double maxMoney = 0;
            for (Map.Entry<String, Double> meMap : peoplesMap.entrySet())
                if (maxMoney <= meMap.getValue())
                        maxMoney = meMap.getValue();

            for (Map.Entry<String, Double> meMap : peoplesMap.entrySet())
                if (meMap.getValue() == maxMoney)
                    System.out.println(meMap.getKey());

        }
    }
}
