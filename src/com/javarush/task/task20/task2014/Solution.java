package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
      //  System.out.println(new Solution(4));

        Solution savedObject = new Solution(4);
        Solution loadObject = new Solution(5);

        String fileName = "C:\\Users\\User\\Desktop\\task2014.txt";

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(savedObject);
        fileOutputStream.close();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        loadObject = (Solution) inputStream.readObject();
        fileInputStream.close();
        inputStream.close();

        System.out.println(loadObject.string.equals(savedObject.string));


    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
