package org.example.Lesson3.Seminar.exes1.task2;

public class NullElementArrayException extends NullPointerException {
    private final int index;

    public int getIndex() {
        return index;
    }

    public NullElementArrayException(String s, int index) {
        super(s);
        this.index = index;
    }
}
