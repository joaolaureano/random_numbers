package com.example;

public class App{
static Random randomGenerator;
    public static void main(String[] args){
        float multiplier = 5;
        float sum = 3;
        float modulus = 17;
        float seed = 7;
        final int QUANTITY_NUMBERS = 100;
        randomGenerator = new Random(multiplier, sum, modulus, seed);

        float[] random_numbers = new float[QUANTITY_NUMBERS];
        for(int i = 0; i < random_numbers.length; i++)
            random_numbers[i] = randomGenerator.next();

        ScatterView.start(random_numbers);
    }
}