package com.hillel.optional;

import java.util.Optional;
import java.util.Random;


public class OptionalDemo {
    public static void main(String[] args) {

        getValueThatNeverWillBeNull(0).ifPresent(System.out::println);
        getValueThatNeverWillBeNull(1).ifPresent(System.out::println);

        saveGettingValue1();
        saveGettingValue2();
        saveGettingValue3();
        saveGettingValue4();
        compareOptionalToSomeValue();

        try {
            saveGettingValue5();
        } catch (RuntimeException e) {
            System.out.println("GOOD JOB :)");
        }
    }


    public static void compareOptionalToSomeValue() {
        Optional<Integer> result = Optional.of(new Random().nextInt(10));
        // check whether some concrete value is represented inside an optional container
        boolean represented = result.filter(i -> i == 5).isPresent(); // check whether result contains 5 or not
        System.out.println("Is the value equals to 5? Answer: " + represented);
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
