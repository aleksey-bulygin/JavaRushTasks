package com.javarush.task.task16.task1632;

public class ThreadThree extends ThreadsSolution {
    @Override
    public void run() {
        try {
            while (!interrupted()) {
                System.out.println("Ура");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {

        }
    }
}
