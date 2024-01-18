package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (validate(args)) {
            Path start = Paths.get(args[0]);
            search(start, path -> path.toFile().getName().endsWith(args[1])).forEach(System.out::println);
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static boolean validate(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Amount of the args doesnt equal 2");
        }
        if (args[1].isBlank()) {
            throw new IllegalArgumentException("The second argument is blank");
        }
        if (args[0].isBlank()) {
            throw new IllegalArgumentException("The first argument is blank");
        }
        return true;
    }
}
