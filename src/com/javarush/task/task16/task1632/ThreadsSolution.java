package com.javarush.task.task16.task1632;

public abstract class ThreadsSolution extends Thread {

    public abstract void run();

    public static ThreadsSolution getThread(ThreadTypes threadTypes)
    {
        ThreadsSolution threadsSolution;

        if (threadTypes == ThreadTypes.TYPES_ONE) {
            threadsSolution = new ThreadOne();
            return threadsSolution;
        }

        if (threadTypes == ThreadTypes.TYPES_TWO) {
            threadsSolution = new ThreadTwo();
            return threadsSolution;
        }

        if (threadTypes == ThreadTypes.TYPES_THREE) {
            threadsSolution = new ThreadThree();
            return threadsSolution;
        }

        if (threadTypes == ThreadTypes.TYPES_FOUR) {
            threadsSolution = new ThreadFour();
            return threadsSolution;
        }

        if (threadTypes == ThreadTypes.TYPES_FIVE) {
            threadsSolution = new ThreadFive();
            return threadsSolution;
        }

        throw new IllegalArgumentException("Type error");

    }
}
