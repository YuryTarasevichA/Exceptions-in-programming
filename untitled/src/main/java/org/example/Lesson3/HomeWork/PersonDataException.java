package org.example.Lesson3.HomeWork;

public class PersonDataException extends PersonException{
    private final String data;

    public String getData() {
        return data;
    }

    public PersonDataException(String message, String data) {
        super(message);
        this.data = data;
    }
}
