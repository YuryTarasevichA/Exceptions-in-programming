package org.example.Lesson2;

import java.io.File;
import java.io.FileReader;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
/*        Object object = new String("123");
        File file = (File) object;
        System.out.println(file);*/

//        String name = null;
//        System.out.println(name.length());

/*        String number = "123sfds";
        int result = Integer.parseInt(number);
        System.out.println(result);*/

//        List<Object> emptyList = Collections.emptyList();
//        emptyList.add(new Object());

/*        int number = 1;
        try{
            number = 10/1;
            String test = null;
            System.out.println(test.length());
        } catch (ArithmeticException e){
            System.out.println("На ноль делить нельзя");
        } catch (NullPointerException e){
            System.out.println("Пустая строка");
        }
        System.out.println(number);*/
        FileReader test = null;
        try{
             test = new FileReader("test");

        } catch (RuntimeException | IOException e){
            System.out.println("catch exception: " + e.getClass().getSimpleName());

        }finally {
            System.out.println("Finally start");
            if (test != null){
                try{
                    test.close();
                } catch (IOException e){
                    System.out.println("exception while close");
                }
            }
            System.out.println("Finally finished");
        }
    }
}
