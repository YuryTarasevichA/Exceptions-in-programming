package org.example.Lesson2.sem;

import java.util.Random;


public class Program {
    static Random random = new Random();

    public static void main(String[] args) {
        try {
            System.out.printf("Сумма всех элементов массива: %d\n", processArrayInternal(generateArray()));
        }catch (MyArrayDataException e){
            System.out.printf("%s по индексу [%d][%d]\n", e.getMessage(), e.getX(), e.getY());
        }catch (MyArraySizeException e){
            System.out.printf("%s требовалось 4x4, получили %dx%d\n", e.getMessage(), e.getX(), e.getY());
        }catch (NullPointerException e){
            e.printStackTrace();
        }


    }

    /**
     * Получить сумму всех элементов двумерного массива строк
     *
     * @param array массив
     * @return сумма элементов массива
     * @throws MyArraySizeException некорректная размерность массива
     * @throws MyArrayDataException ошибка преобразования строки к числу
     * @throws NullPointerException массив должен существовать
     */

    static int processArrayInternal(String[][] array) throws MyArraySizeException, MyArrayDataException, NullPointerException {
        if (array == null) {
            throw new NullPointerException("Массив должен существовать");
        }

        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Не корректный размер массива ", array.length, array[0].length);
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                sum += parseElement(array[i][j], i, j);
            }
        }
        return sum;
    }

    /**
     * Преобразование строки к числу типа int
     *
     * @param s строка
     * @param x координата элемента в массиве
     * @param y координата элемента в массиве
     * @return число
     * @throws MyArrayDataException
     */
    static int parseElement(String s, int x, int y) throws MyArrayDataException {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Не корректный формат данных", x, y);
        }
    }

    static String[][] generateArray() {
        int add = random.nextInt(2);
        String[][] array = new String[4 + add][4 + add];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = Integer.toString(random.nextInt(10, 100));
            }
        }
        if (random.nextInt(3) == 0) { // 33%
            array[random.nextInt(array.length)][random.nextInt(array[0].length)] = "abc";
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%s\t", array[i][j]);
            }
            System.out.println();
        }
        return array;
    }
}
