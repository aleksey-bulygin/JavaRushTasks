package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface extends Runnable {

        void setFileName(String fullFileName);

        String getFileContent() throws FileNotFoundException, IOException, InterruptedException;

        void join() throws InterruptedException;

        void start() throws InterruptedException;
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName;
        private String data = "";

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() throws FileNotFoundException, IOException, InterruptedException {

            return data;
        }



        @Override
        public void run() {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(fullFileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            while (true) {
                try {
                    if (!bufferedReader.ready()) break;
                    data += bufferedReader.readLine() + " ";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
