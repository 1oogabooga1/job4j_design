package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, ArrayList<Path>> duplicates = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
        FileProperty firstFile = new FileProperty(attributes.size(), file.toFile().getName());
        duplicates.computeIfAbsent(firstFile, k -> new ArrayList<>()).add(file);
        return super.visitFile(file, attributes);
    }

    public void printDuplicates() {
        for (Map.Entry<FileProperty, ArrayList<Path>> entry : duplicates.entrySet()) {
            if (entry.getValue().size() > 1) {
                for (Path file : entry.getValue()) {
                    System.out.println(file);
                }
            }
        }
    }
}