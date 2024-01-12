package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader input = new BufferedReader(new FileReader(source));
             PrintWriter output = new PrintWriter(
                     new BufferedOutputStream(
                     new FileOutputStream(target)
                ))) {
            boolean work = true;
            for (String line = input.readLine(); line != null; line = input.readLine()) {
                String[] lines = line.split(" ");
                if (work && ("400".equals(lines[0]) || "500".equals(lines[0]))) {
                    work = false;
                    output.print(lines[1] + ";");
                }
                if (!work && (!"400".equals(lines[0]) && !"500".equals(lines[0]))) {
                    work = true;
                    output.print(lines[1] + ";");
                    output.print(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
