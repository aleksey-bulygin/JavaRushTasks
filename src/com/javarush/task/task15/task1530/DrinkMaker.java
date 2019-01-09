package com.javarush.task.task15.task1530;

public abstract class DrinkMaker {

    protected abstract void getRightCup();
    protected abstract void putIngredient();
    protected abstract void pour();

    protected void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
