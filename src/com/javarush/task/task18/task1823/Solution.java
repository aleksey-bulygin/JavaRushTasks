package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String fileName = bufferedReader.readLine();
            if ("exit".equals(fileName))
                break;
            else {
                ReadThread readThread = new ReadThread(fileName);
                readThread.start();
                readThread.join();

            }
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        private FileInputStream fileInputStream;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                fileInputStream = new FileInputStream(fileName);
                int[] arrayBytesFromFiles = new int[256];
                int maxCounInArray;
                int indexMaxNumber = 0;

                while (fileInputStream.available() > 0)
                {
                    int i = fileInputStream.read();
                    arrayBytesFromFiles[i]++;
                }
                fileInputStream.close();

                maxCounInArray = searchMaxInArray(arrayBytesFromFiles);

                for (int i = 0; i < arrayBytesFromFiles.length; i++)
                    if (maxCounInArray == arrayBytesFromFiles[i])
                        indexMaxNumber = i;

                resultMap.put(fileName, indexMaxNumber);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public int searchMaxInArray(int[] arr) {
            int max = arr[0];

            for (int n : arr)
                if (max < n)
                    max = n;

            return max;
        }
    }
}
