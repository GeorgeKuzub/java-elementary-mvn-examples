package com.hillel.optional;

import java.util.Optional;


public class OptionalDemo {
    public static void main(String[] args) {

        getValueThatNeverWillBeNull(0).ifPresent(System.out::println);
        getValueThatNeverWillBeNull(1).ifPresent(System.out::println);

        saveGettingValue1();
        saveGettingValue2();
        saveGettingValue3();
        saveGettingValue4();


        try {
            saveGettingValue5();
        } catch (RuntimeException e) {
            System.out.println("GOOD JOB :)");
        }
    }


    // ofNullable demonstration
    public static void saveGettingValue1() {
        Optional<String> result = Optional.ofNullable(getValueThatMayBeNull(1));
        result.ifPresent(System.out::println);
    }

    // isPresent and get() demonstration
    public static void saveGettingValue2() {
        Optional<String> result = Optional.of(getValueThatMayBeNull(1));
        if (result.isPresent()) {
            System.out.println(result.get());
        }
    }


    public static void saveGettingValue3() {
        Optional<String> result = getValueThatNeverWillBeNull(0); // result contains Optional.EMPTY here

        // Extract from Optional wrapper:
        System.out.println(result.orElse("Nothing :("));
    }


    public static void saveGettingValue4() {
        Optional<String> result = getValueThatNeverWillBeNull(0); // result contains Optional.EMPTY here
        System.out.println(result.orElseGet(OptionalDemo::getAbsolutelyNothing));
    }

    public static void saveGettingValue5() {
        Optional<String> result = Optional.of(getValueThatMayBeNull(0));
        System.out.println(
                result.orElseThrow(() -> new RuntimeException("Danger value parameter is detected!"))
        );
    }

    private static String getValueThatMayBeNull(int i) {
        if (i == 0) {
            return null;
        } else {
            return "Done";
        }
    }

    private static Optional<String> getValueThatNeverWillBeNull(int i) {
        if (i == 0) {
            return Optional.empty();
        } else {
            return Optional.of("Well Done.");
        }
    }


    private static String getAbsolutelyNothing() {
        return "Default Value1.";
    }
}
