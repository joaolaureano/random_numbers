package com.example;

public class App{
static ScatterView sv = new ScatterView();
static Random randomGenerator;
    public static void main(String[] args){
        float multiplier = 9;
        float sum = 4;
        float modulus = 9;
        float seed = 7;
        final int QUANTITY_NUMBERS = 100;
        float[] random_numbers = new float[QUANTITY_NUMBERS];
        for(int i = 0; i < random_numbers.length; i++)
            random_numbers[i] = randomGenerator.next();
        randomGenerator = new Random(multiplier, sum, modulus, seed);

        // ScatterView.start();   
    }
}