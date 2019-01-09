package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(ThreadsSolution.getThread(ThreadTypes.TYPES_ONE));
        threads.add(ThreadsSolution.getThread(ThreadTypes.TYPES_TWO));
        threads.add(ThreadsSolution.getThread(ThreadTypes.TYPES_THREE));
        threads.add(ThreadsSolution.getThread(ThreadTypes.TYPES_FOUR));
        threads.add(ThreadsSolution.getThread(ThreadTypes.TYPES_FIVE));
    }

    public static void main(String[] args) {
    }


}