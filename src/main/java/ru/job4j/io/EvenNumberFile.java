package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = input.read()) != -1) {
                text.append((char) read);
            }
            String[] numbers = text.toString().split(System.lineSeparator());
            StringBuilder rsl = new StringBuilder();
            for (String s : numbers) {
                int number = Integer.parseInt(s);
                if (number % 2 == 0) {
                    rsl.append(number);
                    rsl.append(System.lineSeparator());
                }
            }
            System.out.println(rsl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
