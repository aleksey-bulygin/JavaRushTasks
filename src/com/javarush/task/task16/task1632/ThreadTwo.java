package com.javarush.task.task16.task1632;

public class ThreadTwo extends ThreadsSolution{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
