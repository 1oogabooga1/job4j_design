package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        String userMsg = input.nextLine();
        boolean run = true;
        while (run) {
            if ("стоп".equals(userMsg)) {
                System.out.println(OUT);
                run = false;
            }
           userMsg = input.nextLine();
        }
        saveLog(readPhrases());
    }

    private List<String> readPhrases() {
        ArrayList<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String phrase = reader.readLine();
            phrases.add(phrase);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
       try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(path, true))) {
           for (String phrase : log) {
               output.write(phrase.getBytes());
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("phrases.txt", "");
        consoleChat.run();
    }
}
