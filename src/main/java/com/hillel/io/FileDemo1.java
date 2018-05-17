package com.hillel.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FileDemo1 {

    public static void main(String[] args) {
        System.out.println("Get only directories specified by some path:");
        getDirectoriesByPath(".").stream().forEach(System.out::println);

        System.out.println("Get all files specified by some path:");
        getFilesByPath(".").stream().forEach(System.out::println);

        String pathToResourceFile =
                ClassLoader.getSystemResource("Test.txt").getFile();

        System.out.println("\nRead from text files -- old style --");
        List<String> lines = readTextFileOld(pathToResourceFile);
        lines.stream().forEach(System.out::println);

        System.out.println("\nRead from text files -- new style --");
        lines = readTextFileNew(pathToResourceFile);
        lines.stream().forEach(System.out::println);

        System.out.println("\nRead from text files -- progressive way --");
        readTextFileProgressive(pathToResourceFile);
        lines = readTextFileProgressive(pathToResourceFile);
        lines.stream().forEach(System.out::println);
    }


    public static List<String> readTextFileProgressive(String name) {
        List<String> result;
        try {
            result = Files.readAllLines(Paths.get(name));
        } catch (IOException e) {
            e.printStackTrace();
            result = Collections.emptyList();
        }
        return result;
    }

    public static List<String> readTextFileNew(String fileName) {
        List<String> result = new LinkedList<>();

        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = bfr.readLine()) != null) {
                result.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
            result = Collections.emptyList();
        }

        return result;
    }


    public static List<String> readTextFileOld(String fileName) {
        List<String> result = new LinkedList<>();
        BufferedReader bfr = null;
        try {
            try {
                bfr =
                        new BufferedReader(new FileReader(fileName));
                String currentLine;

                while ((currentLine = bfr.readLine()) != null) {
                    result.add(currentLine);
                }
            } finally {
                if (bfr != null) {
                    bfr.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            result = Collections.emptyList();
        }

        return result;
    }

    public static List<String> getFilesByPath(String path) {
        File file = new File(path);
        String[] files = file.list();
        return Arrays.asList(files);
    }


    public static List<String> getDirectoriesByPath(String path) {
        File root = new File(path);
        File[] files = root.listFiles();

//        Java style before JDK 8

//        List<String> result = new LinkedList<>();
//        for (File f : files) {
//            if (f.isDirectory()) {
//                result.add(f.getName());
//            }
//        }

//        return result;

//        Java8 style and higher
        return Arrays.stream(files)
                .filter(f -> f.isDirectory())
                .map(f -> f.getName())
                .collect(Collectors.toList());
    }
}
