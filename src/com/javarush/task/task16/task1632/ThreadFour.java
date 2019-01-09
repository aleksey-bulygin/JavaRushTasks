package com.javarush.task.task16.task1632;

public class ThreadFour extends ThreadsSolution implements Message{

    private static boolean aBoolean = true;
    @Override
    public void run() {
        while (aBoolean) {

        }
    }

    @Override
    public void showWarning() throws InterruptedException {
        if (this.isAlive())
            aBoolean = false;
    }
}
