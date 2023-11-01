package org.example.Lesson2.HomeWork.exes1;

class IsFloat {
    public static float isFloat(String input) {
// Введите свое решение ниже
        try{
            float number = Float.parseFloat(input);
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Your input is not a float number. Please, try again.");
            return Float.NaN;
        }

    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        String input;

// При отправке кода на Выполнение, вы можете варьировать эти параметры
        if (args.length == 0) {
            input = "text"; // По умолчанию используем "3.14", если аргумент не передан
        }
        else {
            input = args[0];
        }

        float result = IsFloat.isFloat(input);
        System.out.println(result);
    }
}
