package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;


public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader input = new BufferedReader(new FileReader(path))) {
            for (String line = input.readLine(); line != null; line = input.readLine()) {
                if (!line.isBlank() && !line.contains("#")) {
                    String[] lines = line.split("=", 2);
                    if (validate(lines)) {
                        throw new IllegalArgumentException();
                    } else {
                        values.put(lines[0], lines[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String[] lines) {
        boolean check =  lines.length < 2 || " ".equals(lines[0]) || " ".equals(lines[1]);
        if (check) {
            throw new IllegalArgumentException();
        }
        return check;
    }

    public String value(String key) {
       return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }
}
