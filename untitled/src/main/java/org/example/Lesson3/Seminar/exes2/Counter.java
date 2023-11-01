package org.example.Lesson3.Seminar.exes2;

public class Counter implements AutoCloseable {

    private int counter;
    private boolean isOpen;

    public int getCounter() {
        return counter;
    }

    /**
     * Увеличивает значение текущего счётчика на 1
     * @return актуальное значение счётчика
     * @throws ClouseCounterException Счётчик закрыт
     */
    public int add() throws ClouseCounterException {
        if (!isOpen) {
            throw new ClouseCounterException("Счётчик закрыт");
        }
        return ++counter;
    }

    public Counter() {
        isOpen = true;
    }

    public Counter(int counter) {
        this.counter = counter;
        isOpen = true;
    }

    public void clouseCounter() {
        isOpen = false;
    }

    @Override
    public void close() {
        clouseCounter();
    }


}
