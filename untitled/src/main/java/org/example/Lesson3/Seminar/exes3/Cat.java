package org.example.Lesson3.Seminar.exes3;

public class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    /**
     * Заставить котика поплавать
     * @param distance дистанция
     * @throws AnimalSwimException Кот не умеет плавать
     */
    @Override
    void swim(int distance) throws AnimalSwimException {
        throw new AnimalSwimException("Кот не умеет плавать", name, distance);
    }

    /**
     * Заставить котика побегать
     * @param distance дистанция
     * @throws AnimalRunException Котику тяжело бежать
     */
    @Override
    void run(int distance) throws AnimalRunException {
        if (distance < 60) {
            //TODO:...
        } else {
            throw new AnimalRunException("Котику тяжело бежать", name, distance);
        }
    }

    /**
     * Фабричный метод для создания объекта
     *
     * @param name имя котика
     * @return котик
     * @throws AnimalNameException Некорректное имя животного
     */
    public static Cat create(String name) throws AnimalNameException {
        if (name == null || name.length() < 3) {
            throw new AnimalNameException("Некорректное имя животного", name);
        }
        return new Cat(name);
    }
}
