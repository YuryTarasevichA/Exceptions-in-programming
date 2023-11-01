package org.example.Lesson3.Seminar.exes3;

import java.util.Random;

public class Program {
    /**
     * Задача 3:
     * =========
     * Спроектировать серию классов для работы с животным. Защитить состояние и поведение
     * класса используя исключения.
     */
    public static void main(String[] args) {
        try {
            Animal animal1 = Cat.create("Барсик");
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int j = random.nextInt(2);
                try {
                    switch (j) {
                        case 0 -> {
                            animal1.swim(i * 10);
                            System.out.println("Котик успешно проплыл дистанцию. ");
                        }
                        case 1 -> {
                            animal1.run(i * 10);
                            System.out.println("Котик успешно пробежал дистанцию. ");
                        }
                    }
                } catch (AnimalRunException e) {
                    System.out.printf("Исключение при попытке %s пробежать %d метров.\n",
                            e.getName(), e.getDistance());
                    System.out.println(e.getMessage());
                } catch (AnimalSwimException e) {
                    System.out.printf("Исключение при попытке %s проплыть %d метров.\n",
                            e.getName(), e.getDistance());
                    System.out.println(e.getMessage());
                }

            }
        } catch (AnimalNameException e) {
            System.out.println(e.getMessage());
        }

    }
}
