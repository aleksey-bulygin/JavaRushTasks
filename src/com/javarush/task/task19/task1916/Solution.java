package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> dataFromFileOne = new ArrayList<>();
        ArrayList<String> dataFromFileTwo = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = bufferedReader.readLine();
        String fileNameTwo = bufferedReader.readLine();
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileNameOne));
        while (bufferedReader.ready())
            dataFromFileOne.add(bufferedReader.readLine());
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileNameTwo));
        while (bufferedReader.ready())
            dataFromFileTwo.add(bufferedReader.readLine());
        bufferedReader.close();


        int index1 = 0;
        int index2 = 0;

        while (index1 < dataFromFileOne.size() && index2 < dataFromFileTwo.size()) {

            if (dataFromFileOne.get(index1).equals(dataFromFileTwo.get(index2))) {
                lines.add(new LineItem(Type.SAME, dataFromFileOne.get(index1)));
                index1++;
                index2++;
            } else if (index1 + 1 < dataFromFileOne.size() && dataFromFileOne.get(index1 + 1).equals(dataFromFileTwo.get(index2)))
                lines.add(new LineItem(Type.REMOVED, dataFromFileOne.get(index1++)));
            else if (index2 + 1 < dataFromFileTwo.size() && dataFromFileOne.get(index1).equals(dataFromFileTwo.get(index2 + 1)))
                lines.add(new LineItem(Type.ADDED, dataFromFileTwo.get(index2++)));
        }
        if (index1 == dataFromFileOne.size() && index2 < dataFromFileTwo.size())
            lines.add(new LineItem(Type.ADDED, dataFromFileTwo.get(index2)));
        if (index2 == dataFromFileTwo.size() && index1 < dataFromFileOne.size())
            lines.add(new LineItem(Type.REMOVED, dataFromFileOne.get(index1)));



    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
