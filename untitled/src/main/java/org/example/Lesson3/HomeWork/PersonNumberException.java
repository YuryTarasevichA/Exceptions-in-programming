package org.example.Lesson3.HomeWork;

public class PersonNumberException extends NumberFormatException{
    private final int number;

    public PersonNumberException(String message, int number) {
        super(message);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
