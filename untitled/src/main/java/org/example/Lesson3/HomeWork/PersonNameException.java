package org.example.Lesson3.HomeWork;

public class PersonNameException extends PersonException{
    private final String name;

    public String getName() {
        return name;
    }

    public PersonNameException(String message, String name) {
        super(message);
        this.name = name;
    }
}
