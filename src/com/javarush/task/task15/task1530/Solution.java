package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {

        DrinkMaker teaMaker = new TeaMaker();
        DrinkMaker latteMaker = new LatteMaker();

        teaMaker.makeDrink();

        latteMaker.makeDrink();
    }
}
