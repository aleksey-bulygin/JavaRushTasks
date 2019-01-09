package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
       // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        stream = new FileOutputStream(fileName, true);
        in.defaultReadObject();
      //  in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {

        Solution solutionOne = new Solution("C:\\Users\\User\\Desktop\\task2022.txt");
      //  solutionOne.writeObject("data");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\User\\Desktop\\task2022res.txt"));
        outputStream.writeObject(solutionOne);
        outputStream.close();


        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Desktop\\task2022res.txt"));
        Solution newSol = (Solution) inputStream.readObject();
        inputStream.close();
       // newSol.writeObject("data");



       // Solution solutionResul;
      //  ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Desktop\\task2022.txt"));
       // solutionOne.readObject(inputStream);

    }
}
