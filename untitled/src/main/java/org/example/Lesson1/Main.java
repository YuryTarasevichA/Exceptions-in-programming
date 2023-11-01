package org.example.Lesson1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println(divide(10, 0));
//        System.out.println(getFileSize(new File("D:/GeekBrains/исключения в программировании/untitled/src/test/TestFile")));
//        a();
    }

    public static void a() {
        b();
    }

    public static void b() {
        c();
    }

    public static void c() {
        int[] ints = new int[10];
        System.out.println(ints[1000]);
    }

    public static int divide(int a1, int a2) {
        if (a2 == 0) {
            throw new RuntimeException("Divide by zero not permited");
        }
        return a1 / a2;
    }

    public static long getFileSize(File file) {
        if (!file.exists()) {
            return -1L;
        }
        return file.length();
    }
}