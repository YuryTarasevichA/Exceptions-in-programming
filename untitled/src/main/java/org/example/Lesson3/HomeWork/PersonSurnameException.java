package org.example.Lesson3.HomeWork;

public class PersonSurnameException extends PersonException{
    private final String surname;

    public String getSurname() {
        return surname;
    }

    public PersonSurnameException(String message, String surname) {
        super(message);
        this.surname = surname;
    }
}
