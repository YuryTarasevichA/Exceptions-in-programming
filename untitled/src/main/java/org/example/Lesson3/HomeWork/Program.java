package org.example.Lesson3.HomeWork;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try(FileWriter fileWriter = new FileWriter("person.txt")) {
            System.out.println("Введите данные пользователя в формате:" +
                    " Фамилия Имя Отчество Датарождения Номертелефона Пол");
            String inputPerson = scanner.nextLine();
            String[] userPerson = inputPerson.split(" ");

            String family = userPerson[0];
            String name = userPerson[1];
            String surname = userPerson[2];
            String dataFormat = userPerson[3];
            Long phoneNumber = Long.parseLong(userPerson[4]);
            char sex = userPerson[5].charAt(0);
            Person person = Person.create(family, name, surname, dataFormat, Math.toIntExact(phoneNumber), sex);
            fileWriter.write("Фамилия: " + family + "\n");
            fileWriter.write("Имя: " + name + "\n");
            fileWriter.write("Отчество: " + surname + "\n");
            fileWriter.write("Дата рождения: " + dataFormat + "\n");
            fileWriter.write("Номер телефона: " + phoneNumber + "\n");
            fileWriter.write("Пол: " + sex + "\n");
            fileWriter.write("--------------------\n");
            System.out.println("Данные записаны в файл.");
        } catch (PersonNameException | PersonFamilyException | PersonSurnameException |
                 PersonDataException | PersonNumberException | PersonSexException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
            e.printStackTrace();
        }
    }
}


