package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();


    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        InputStream inputStream = new FileInputStream(fileName);
        load(inputStream);

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        Properties prop = new Properties();

        if (!properties.isEmpty()) {
            for (Map.Entry entry : properties.entrySet())
                prop.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }

        prop.store(bufferedWriter, "");
        bufferedWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();

        prop.load(inputStream);

        for (String name : prop.stringPropertyNames()) {
            properties.put(name, prop.getProperty(name));
        }

        inputStream.close();
    }

    public static void main(String[] args) {

    }
}
