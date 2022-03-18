package com.example;

public class Random{
    float a_multiplier, c_sum,m_modulus, previous_number;
    Random(float multiplier,float sum, float modulus,float seed){
        a_multiplier = multiplier;
        c_sum = sum;
        m_modulus = modulus;
        previous_number = seed;
    }
    public float next(){
        return generateNext(previous_number, a_multiplier, c_sum, m_modulus);
    }
    private float generateNext(float previous_number,float a_multiplier,float c_sum,float m_modulus){
        return (a_multiplier * previous_number + c_sum) % m_modulus / m_modulus;
    }
}