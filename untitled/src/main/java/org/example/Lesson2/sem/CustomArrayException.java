package org.example.Lesson2.sem;

public abstract class CustomArrayException extends Exception {
    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CustomArrayException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }
}
