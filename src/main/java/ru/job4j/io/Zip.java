package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toAbsolutePath().toString()));
                try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(output.readAllBytes());
                }
                zip.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean validate(String[] args) {
        ArgsName keyValue = ArgsName.of(args);
        if (keyValue.get("d").isBlank() || keyValue.get("e").isBlank() || keyValue.get("o").isBlank()) {
            throw new IllegalArgumentException("Missing some argument");
        }
        if (!Files.isDirectory(Paths.get(keyValue.get("d")))) {
            throw new IllegalArgumentException("Invalid path");
        }
        if (!keyValue.get("e").startsWith(".") || keyValue.get("e").length() <= 1) {
            throw new IllegalArgumentException("Invalid file extension");
        }
        if (!keyValue.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("Incorrect archive extension");
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        if (validate(args)) {
            Zip zip = new Zip();
            String sourceDirectory = ArgsName.of(args).get("d");
            String targetZipFile = ArgsName.of(args).get("o");
            Path sourcePath = Paths.get(sourceDirectory);
            List<Path> sourceFiles = Search.search(sourcePath, path -> true);
            zip.packFiles(sourceFiles, new File(targetZipFile));
            zip.packSingleFile(
                    new File("./pom.xml"),
                    new File("./pom.zip")
            );
        }
    }
}
