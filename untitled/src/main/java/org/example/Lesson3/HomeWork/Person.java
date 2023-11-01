package org.example.Lesson3.HomeWork;

public class Person {
    private final String name;
    private final String family;
    private final String surname;
    private final String dataFormat;
    private final int phoneNumber;
    private final char sex;

    public char getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getSurname() {
        return surname;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Person(String family, String name,
                  String surname, String dataFormat,
                  int phoneNumber, char sex) {
        this.family = family;
        this.name = name;
        this.surname = surname;
        this.dataFormat = dataFormat;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public static Person create(String family, String name,
                                String surname, String dataFormat,
                                int phoneNumber, char sex) throws PersonNameException, PersonFamilyException,
            PersonSurnameException, PersonDataException,
            PersonNumberException, PersonSexException {
        if (family == null || family.length() < 3) {
            throw new PersonFamilyException("Некорректная фамилия ", family);
        }
        if (name == null || name.length() < 2) {
            throw new PersonNameException("Некоректное имя ", name);
        }
        if (surname == null || surname.length() < 3) {
            throw new PersonSurnameException("Некоректное отчество ", surname);
        }
        if (dataFormat == null || !dataFormat.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new PersonDataException("Некорректный формат даты ", dataFormat);
        }
        if (!isNumber(String.valueOf(phoneNumber)) || String.valueOf(phoneNumber).length() != 5) {
            throw new PersonNumberException("Некорректный номер телефона ", phoneNumber);
        }
        if ((sex != 'M') && (sex != 'W')) {
            throw new PersonSexException("Не корректно указан пол, введите 'M' или 'W' ", sex);
        }
        return new Person(family, name, surname, dataFormat, phoneNumber, sex);

    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
