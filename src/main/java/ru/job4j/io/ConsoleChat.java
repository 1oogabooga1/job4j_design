package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        boolean run = true;
        boolean stop = false;
        List<String> log = new ArrayList<>();
        Random ran = new Random();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (run) {
                String userInput = reader.readLine();
                if ("стоп".equals(userInput)) {
                    System.out.println(STOP);
                    log.add(userInput);
                    stop = true;
                }
                if (!"стоп".equals(userInput) && !"закончить".equals(userInput) && !stop) {
                    int random = ran.nextInt(readPhrases().size() - 1);
                    System.out.println(readPhrases().get(random));
                    log.add(userInput);
                }
                if ("закончить".equals(userInput)) {
                    System.out.println(OUT);
                    log.add(userInput);
                    run = false;
                }
                if ("продолжить".equals(userInput)) {
                    System.out.println(CONTINUE);
                    log.add(userInput);
                    stop = false;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        ArrayList<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                phrases.add(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
       try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(path, true))) {
           for (String phrase : log) {
               output.write((phrase + System.lineSeparator()).getBytes());
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/phrases.txt", "data/botAnswers.txt");
        consoleChat.run();
    }
}
