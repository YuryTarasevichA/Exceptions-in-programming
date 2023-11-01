package org.example.Lesson3.Seminar.exes3;

public class AnimalFabric {
    public static Animal create(AnimalType animalType, String name) throws AnimalNameException {
        if (name == null || name.length() < 3) {
            throw new AnimalNameException("Некорректное имя животного", name);
        }
        switch (animalType){
            case Cat -> {
                return new Cat(name);
            }/*case Dog -> {
                return new Dog(name);
            }*/default -> {
                throw new RuntimeException();
            }
        }


    }
}
