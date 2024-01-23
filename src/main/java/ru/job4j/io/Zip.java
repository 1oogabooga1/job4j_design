package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                Path relativePath = Paths.get("").relativize(target.toPath());
                zip.putNextEntry(new ZipEntry(relativePath.toString()));
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
        return true;
    }

    public static void main(String[] args) {
        Zip zip = new Zip();
        String sourceDirectory = ArgsName.of(args).get("d");
        String targetZipFile = ArgsName.of(args).get("o");
        Path sourcePath = Paths.get(sourceDirectory);
        List<Path> sourceFiles = new ArrayList<>();
        File sourceDir = new File(sourceDirectory);
        File[] files = sourceDir.listFiles();
        if (files != null) {
            for (File file : files) {
                sourceFiles.add(file.toPath());
            }
        }
        zip.packFiles(sourceFiles, new File(targetZipFile));
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}
