package ru.job4j.io;


import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String output = argsName.get("out");
        String filter = argsName.get("filter");
        String[] filters = filter.split(",");
        List<Integer> headIndex = new ArrayList<>();
        List<String> headers = new ArrayList<>();
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(output))) {
            try (var scanner = new Scanner(new FileInputStream(path))) {
                scanner.useDelimiter(delimiter);
                String[] line = scanner.nextLine().split(delimiter);
                headers.addAll(Arrays.asList(line));
                for (String s : filters) {
                    for (int i = 0; i < headers.size(); i++) {
                        if (headers.get(i).equals(s)) {
                            headIndex.add(i);
                            out.write(headers.get(i).getBytes());
                            if (!s.equals(filters[filters.length - 1])) {
                                out.write(delimiter.getBytes());
                            }
                        }
                    }
                }
                out.write(System.lineSeparator().getBytes());
                while (scanner.hasNextLine()) {
                    String[] info = scanner.nextLine().split(delimiter);
                    for (int i = 0; i < headIndex.size(); i++) {
                        for (int f = 0; f < info.length; f++) {
                            if (f == headIndex.get(i)) {
                                out.write(info[f].getBytes());
                                if (!Objects.equals(headIndex.get(i), headIndex.get(headIndex.size() - 1))) {
                                    out.write(delimiter.getBytes());
                                }
                            }
                        }
                    }
                    out.write(System.lineSeparator().getBytes());
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}