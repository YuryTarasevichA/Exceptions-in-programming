package org.example.Lesson2.sem.task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        prepareFile();
    }

    static Random random = new Random();

    static void prepareFile() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("name.txt");
            fileWriter.write("Анна=4\n");
            fileWriter.write("Елена=5\n");
            fileWriter.write("Марина=6\n");

            if (random.nextInt(2) == 0) {
                throw new Exception("Неожиданное исключение");

            }
            fileWriter.write("Владимир=8\n");
            fileWriter.write("Константин=10\n");
            fileWriter.write("Иван=4\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try{
                fileWriter.close();
            }
            catch (IOException e){

            }

        }

    }
}
