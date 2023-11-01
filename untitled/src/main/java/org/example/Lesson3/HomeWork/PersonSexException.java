package org.example.Lesson3.HomeWork;

public class PersonSexException extends PersonException{
    private final char sex;

    public char getSex() {
        return sex;
    }

    public PersonSexException(String message, char sex) {
        super(message);
        this.sex = sex;
    }
}
