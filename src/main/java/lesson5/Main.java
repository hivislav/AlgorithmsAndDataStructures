package lesson5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача №1. Написать программу по возведению числа в степень с помощью рекурсии.");
        System.out.println("=========================");
        System.out.println("Возведение в положительную степень");
        System.out.println(RecursionFunction.recursionFunction(5, 5));
        System.out.println("Возведение в отрицательную степень");
        System.out.println(RecursionFunction.recursionFunction(5, -3));
    }
}
