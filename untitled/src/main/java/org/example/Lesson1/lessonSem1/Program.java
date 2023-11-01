package org.example.Lesson1.lessonSem1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //System.out.printf("Количество элементво массива: %d\n", task1(new int[]{1, -5, 2, 3, 4, 5}));
        //task2();
        //task3();
        //task4();
        task5();
    }
    /**
     Задача 1
     ========
     Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
     Если длина массива меньше некоторого заданного минимума, метод возвращает
     -1, в качестве кода ошибки, иначе - длину массива.
     */
    static int task1(int[] array) {
        if (array == null) {
            return -2;
        }
        if (array.length < 1) {
            return -1;
        }
        return array.length;
    }


    /**
     Задача 2
     ========
     Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
     Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
     1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
     2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
     3. если вместо массива пришел null, метод вернет -3
     4. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
     Напишите метод, в котором реализуйте взаимодействие с пользователем.
     То есть, этот метод запросит искомое число у пользователя, вызовет первый,
     обработает возвращенное значение и покажет читаемый результат пользователю.
     Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
     */

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static void task2() {
        while (true) {
            System.out.println("Укажите значение для поиска: ");
            int searchNumber = Integer.parseInt(scanner.nextLine());
            int[] array = new int[random.nextInt(5) + 1];
            if (random.nextInt(2) == 0) {
                array = null;
            }
            if (array != null) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(10);
                    System.out.printf("%d\t", array[i]);
                }
                System.out.println();
            }
            int codeResult = processArray(array, searchNumber);
            switch (codeResult) {
                case -3 -> System.out.println("массив не корректно проинициализирован");
                case -2 -> System.out.println("элемент не найден");
                case -1 -> System.out.println("длина массива менее трёх символов");
                default -> {
                    System.out.println(" Массив успешно обработан. Завершение работы приложения");
                    System.out.printf(" Элемент найден по идексу: %d\t");
                    return;
                }
            }
        }
    }
    /**
     *
     * @param array
     * @param searchArray
     * @return -1 - Длина массива менее трех символов; - 2 Элемент не найден; -3 - Массив некорректно проинициализирован
     */
    static int processArray(int[] array, int searchArray) {
        if (array == null)
            return -3; // массив не корректно проинициализирован
        if (array.length < 3) {
            return -1; // длина массива менее трёх символов
        }
        Arrays.sort(array);
        for (int e : array)
            System.out.printf("%d\t", e);
        System.out.println();
        int searchResult = Arrays.binarySearch(array, searchArray);
        if (searchResult < 0)
            return -2; // элемент не найден
        return searchResult;
    }
    /**
     Задача 3
     ========
     Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
     Необходимо посчитать и вернуть сумму элементов этого массива.
     При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
     (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
     Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибки.
     */
    static void task3(){
        for (int i = 0; i < 5; i++) {
            processArray(generateArray());
        }
    }

    static void processArray(int[][] array) {
        if (array.length != array[0].length)
            throw new RuntimeException("Неккоректная размерность массива ");
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1)
                    throw new RuntimeException(String.format("неккоректное значение элемента массива по индексу [%d][%d]", i, j));
                else sum += array[i][j];
            }
        }
        System.out.println("Сумма элементвов массива: " + sum);

    }

    /**
     * Генерация двумерного массива
     * @return массив
     */

    static int[][] generateArray() {
        int[][] array = new int[random.nextInt(4, 6)][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = random.nextInt(2);
            }
        }
        if (random.nextInt(2) == 0) {
            array[random.nextInt(array.length)][random.nextInt(array[0].length)] = 2;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
        return array;
    }

    /**
     Задача 4
     ========
     Переработать реализацию задачи 3 с использованием кодов ошибок
     */

    static void task4(){
        for (int i = 0; i < 5; i++){
            int errCode = processArrayV2(generateArray());
            switch (errCode){
                case -1 -> System.out.println("Некорректный размер массива");
                case -2 -> System.out.println("Некорректное значение массива");
                default -> {
                    System.out.printf("Сумма элементов массива: %d\n", errCode);
                }
            }
        }
    }

    static int processArrayV2(int[][] array){
        if (array.length != array[0].length)
            return -1;//throw new RuntimeException(String.format("Некорректная размерность массива [%d][%d]", array.length, array[0].length ));
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                if (array[i][j] != 0 && array[i][j] != 1)
                    return -2;
                    //throw new RuntimeException(String.format("Некорректное значение элемента массива по индексу [%d][%d]",
                    //        i, j));
                else
                    sum += array[i][j];
            }
        }
        //System.out.println("Сумма элементов массива: " + sum);
        return sum;
    }

    /**
     Задача 5
     ========
     Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     и возвращающий новый массив, каждый элемент которого равен сумме элементов двух
     входящих массивов в той же ячейке.
     Если длины массивов не равны, необходимо как-то оповестить пользователя.
     */
    
    static void task5(){
        try{
            int[] res = getSumArray(new int[]{1, 2, 3}, new int[]{2, 8, -1, -4});
            for (int e : res) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        }
        catch (CustomArraySizeException e){
            System.out.println(e.getMessage());
            System.out.println("Длинна первого массива: " + e.getLength1());
            System.out.println("Длинна второго массива: " + e.getLength2());
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }
    static int[] getSumArray(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            throw new NullPointerException("Оба массива должны существовать");
        }
        if (array1.length != array2.length) {
            throw new CustomArraySizeException("Количество элементов массива должно быть одинаково", array1.length, array2.length);
            
        }
        int [] res = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            res[i] = array1[i] + array2[i];
        }
        return res;
    }

}
