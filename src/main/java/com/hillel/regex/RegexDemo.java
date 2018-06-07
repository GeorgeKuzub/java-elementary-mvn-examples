package com.hillel.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
//        primer1(); // Full matching 1
//        primer2(); // Full matching 2

//        findSubstring();

//        replaceAll();

//        splittingString();

        phoneNumberCheck();

    }

    public static void primer1() {
        String input = "Hello";
        boolean found = Pattern.matches("Hello", input);
        System.out.println("Primer1:");

        if (found) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
        System.out.println();
    }

    public static void primer2() {
        String inputStr = "Hello";
        Pattern pattern = Pattern.compile("Hello");
        Matcher matcher = pattern.matcher(inputStr);

        System.out.println("Primer2:");
        if (matcher.matches()) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
        System.out.println();
    }

    private static void findSubstring() {
        String input = "Hello Java! Hello JavaScript! JavaSE 8.";
        Pattern pattern = Pattern.compile("Java(\\w*)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }


    private static void replaceAll() {
        String input = "Hello Java! Hello JavaScript! JavaSE 8.";
        Pattern pattern = Pattern.compile("Java(\\w*)");
        Matcher matcher = pattern.matcher(input);
        String newStr = matcher.replaceAll("HTML5");
        System.out.println(newStr); // Hello HTML5! Hello HTML5! HTML5 8.
    }

    private static void splittingString() {
        String input = "Hello Java! Hello JavaScript! JavaSE 8. True?";

        Pattern pattern = Pattern.compile("[ ,.!?_]+");
//        Pattern pattern = Pattern.compile("\\s*(\\s|,|!|\\.)\\s*");

        String[] words = pattern.split(input);
        for (String word : words)
            System.out.println(word);
    }

    private static void phoneNumberCheck() {
        String pattern = "\\d\\d\\d([,\\s])?\\d\\d\\d\\d";
        String s = "1233323322";
        if ((!s.matches(pattern))) {
            System.out.println("It's not a phone number");
        }

        s = "1233323";
        if ((s.matches(pattern))) {
            System.out.println("It's a phone number");
        }
        s = "123  3323";
        if ((s.matches(pattern))) {
            System.out.println("It's a phone number as well.");
        } else {
            System.out.println("It's not a phone number");
        }
    }

}
