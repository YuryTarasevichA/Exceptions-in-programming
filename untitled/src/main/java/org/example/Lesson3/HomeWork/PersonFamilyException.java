package org.example.Lesson3.HomeWork;

public class PersonFamilyException extends PersonException{
    private final String family;

    public String getFamily() {
        return family;
    }

    public PersonFamilyException(String message, String family) {
        super(message);
        this.family = family;
    }
}
