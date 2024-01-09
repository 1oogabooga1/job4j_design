package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            for (String line = input.readLine(); line != null; line = input.readLine()) {
                String[] lines = line.split("1\"");
                for (int i = 1; i < lines.length; i++) {
                    String[] second = lines[i].split(" ");
                    for (int j = 0; j < second.length; j++) {
                        if (second[j].equals("404") && !second[j + 1].equals("-")) {
                            rsl.add(line);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);

    }
}