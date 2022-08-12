package com.example.calculatorapi.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculator {
    public Double sum(Double number1, Double number2) {
        Double soma = number1 + number2;

        if(number1 == null || number1.equals("") || number2 == null || number2.equals("")){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return soma;
    }

    public Double sub(Double number1, Double number2) {
        Double subtracao=number1 - number2;
        if(number1 == null || number1.equals("") || number2 == null || number2.equals("")){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return subtracao;
    }

    public Double divide (Double number1, Double number2)  {
        Double divisao = number1 / number2;

        if(number1 == null || number1.equals("") || number2 == null || number2.equals("")){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        } else if (number1 == 0 || number2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }
        return divisao;
    }

    public Integer factorial(Integer factorial) {
        if(factorial == null || factorial.equals("")){
            throw new NullPointerException("Número é obrigatório.");
        } else if (factorial == 0) {
            return 1;
        }
        return (factorial*factorial(factorial-1));
    }

    public Integer integerToBinary(Integer integer) {
        return Integer.parseInt(Integer.toBinaryString(integer));
    }

    public String integerToHexadecimal(Integer integer) {
        return Integer.toHexString(integer);
    }

    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        return (int) ChronoUnit.DAYS.between(date1, date2);
    }
}