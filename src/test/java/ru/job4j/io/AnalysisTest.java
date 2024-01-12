package ru.job4j.io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnalysisTest {
    @Test
    void whenOnePeriod(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        String ln = System.lineSeparator();
        try (PrintWriter output = new PrintWriter(source)) {
            output.println("200 10:56:01" + ln
                    + "500 10:57:01" + ln
                    + "400 10:58:01" + ln
                    + "500 10:59:01" + ln
                    + "400 11:01:02" + ln
                    + "300 11:02:02");
        }
        File target = tempDir.resolve("target.txt").toFile();
        Analysis an = new Analysis();
        an.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder result = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(result::append);
        }
        assertThat("10:57:01" + "11:02:02").hasToString(result.toString());
    }

    @Test
    void whenOTwoPeriods(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        String ln = System.lineSeparator();
        try (PrintWriter output = new PrintWriter(source)) {
            output.println("200 10:56:01" + ln
                    + "500 10:57:01" + ln
                    + "400 10:58:01" + ln
                    + "300 10:59:01" + ln
                    + "500 11:01:02" + ln
                    + "200 11:02:02");
        }
        File target = tempDir.resolve("target.txt").toFile();
        Analysis an = new Analysis();
        an.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder result = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(result::append);
        }
        assertThat("10:57:01" + "10:59:01" + "11:01:02" + "11:02:02").hasToString(result.toString());
    }
}