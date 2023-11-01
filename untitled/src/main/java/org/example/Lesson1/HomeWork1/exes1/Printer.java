package org.example.Lesson1.HomeWork1.exes1;

import java.util.Arrays;
import java.util.Random;

/*
Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
        Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива
        Метод divisionByZero - Деление на 0
        Метод numberFormatException - Ошибка преобразования строки в число
        Важно: они не должны принимать никаких аргументов
        */
class Answer {
    public static void arrayOutOfBoundsException() {
        Random random = new Random();
    int [] array1 = new int[3];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(9);
        }
    array1[3] = 12;
        System.out.println(Arrays.toString(array1));

}

    public static void divisionByZero() {
        Random random = new Random();
        int a = random.nextInt(9);
        int b = 0;
        double c = a/b;
        System.out.println(c);

    }

    public static void numberFormatException() {
        String message = "123asd";
        int number = Integer.parseInt(message);
        System.out.println(number);
    }
}

public class Printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}