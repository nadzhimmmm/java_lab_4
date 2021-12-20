package com.company;

import com.company.model.Human;
import com.company.reader.ReadCSV;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ///foreign_names.csv;
        char separator = ';';
        String csvFilePatch1;
        Scanner in = new Scanner(System.in);
        int c=0;

        System.out.println("Введите имя файла (/имя_файла.тип_файла):");
        csvFilePatch1=in.nextLine();
        ReadCSV read = new ReadCSV();
        List<Human> result = read.readDataFromCsvFile(csvFilePatch1, separator);
        System.out.println("1)Введите номер строки работника, чтобы получить информацию о нем.");
        System.out.println("2)вывести всех работников.");
        System.out.println("0)Выход.");
        while (!in.hasNextInt()) {
            System.out.println("Ошибка. Неверный ввод. Введите целое число.");
            in.next();
        }
        int quit = in.nextInt();
        while (quit<0||quit>2) {
            System.out.println("Ошибка. Введите число от нуля до двух.");
            while (!in.hasNextInt()) {
                System.out.println("Ошибка. Неверный ввод. Введите целое число.");
                in.next();
            }
            quit = in.nextInt();

        }

        while(quit!= 0) {
            if (quit == 2) {
                for (Human human : result) {
                    System.out.println(human);
                }
            } else if (quit == 1) {
                System.out.println("Номер строки сотрудника:");
                while (!in.hasNextInt()) {
                    System.out.println("Ошибка. Неверный ввод. Введите целое число.");
                    in.next();
                }
                int mot = in.nextInt();
                if(mot>=1&&mot<=25898)
                    System.out.println(result.get(Integer.parseInt(String.valueOf(mot)) - 1));
                else System.out.println("Неверный индекс.");


            }
            System.out.println("1)Введите номер строки работника, чтобы получить информацию о нем.");
            System.out.println("2)вывести всех работников.");
            System.out.println("0)Выход.");
            while (!in.hasNextInt()) {
                System.out.println("Ошибка. Неверный ввод. Введите целое число.");
                in.next();
            }
            quit = in.nextInt();
            while (quit<0||quit>2) {
                System.out.println("Ошибка. Введите число от нуля до двух.");
                while (!in.hasNextInt()) {
                    System.out.println("Ошибка. Неверный ввод. Введите целое число.");
                    in.next();
                }
                quit = in.nextInt();

            }
        }
    }

}
