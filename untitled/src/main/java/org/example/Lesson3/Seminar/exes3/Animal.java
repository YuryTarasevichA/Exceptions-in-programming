package org.example.Lesson3.Seminar.exes3;

public abstract class Animal {
    protected final String name;

    public String getName() {
        return name;
    }

    protected Animal(String name) {
       this.name = name;
    }

    abstract void swim(int distance) throws AnimalSwimException;
    abstract void run(int distance) throws  AnimalRunException;
}
