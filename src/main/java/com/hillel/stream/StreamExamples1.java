package com.hillel.stream;

import com.hillel.stream_intro.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples1 {

    public static void main(String[] args) {
        // Different ways of getting streams
        initStreams();

        // Returns true if every elements satisfied to a condition
        allMatchExample();

        // Returns true if at least one element of a stream satisfied to a condition
        anyMatchExample();

        // Returns false if at least one element of a stream satisfied to a condition
        noneMatchExample();

        // Concatenation of multiple streams
        concatExample();

        // Returns length of elements of a stream
        countExample();

        // Returns a stream of an unique elements
        distinctExample();

        // Getting all strings that don't start with "h"
        filterExample();

        // Getting any element from a stream if this one is exist
        findAnyExample();

        /* Converting any nested collections(and any other type of containers)
           to one flat stream */
        flatMapExample();

        // Performing some operation on each of element in order way
        forEachOrderedExample();

        /* Generating infinitive elements.
           It should be limited to get final number of elements */
        generateExample();

        /* Generating infinitive elements with some step.
          It should be limited to get final number of elements. */
        iterateExample();

        // Limiting a stream by number of elements
        limitExample();


        // Converting type of elements to another type and return a new stream
        mapExample();


        // Getting max element in the stream
        maxExample();


        // Getting min element in the stream
        minExample();

        /* Peek - nothing to do special on elements in a stream,
         * but you may specify some operation on each element of the stream */
        peekExample();

        /* Getting of IntStream only for Integer element
        * IntStream is a special stream that may contain only element of Integer type*/
        intStreamExample();

    }

    /**
     * Different ways of getting streams
     */
    public static void initStreams() {

        // Direct creating stream of doubles:
        Stream<Double> doubleStream = Stream.<Double>of(0.1, 0.2, 0.3);

        // Getting one from any collection
        Collection collectionStrings =
                Arrays.asList("Africa",
                        "Europe",
                        "North America",
                        "Asia",
                        "Antarctica",
                        "South America",
                        "Australia");

        Stream<String> continents = collectionStrings.stream();

        //Getting from array
        Character[] cutAlphabet = {'a', 'b', 'c', 'e', 'f', 'g', 'h', 'z'};
        Stream<Character> charStream = Arrays.stream(cutAlphabet);


        //Building stream using special methods: add() and build()
        Stream<User> users =
                Stream.<User>builder()
                        .add(new User("User1"))
                        .add(new User("User2"))
                        .add(new User("User3"))
                        .build();
    }


    /**
     * Returns true if every elements satisfied to a condition
     */
    public static boolean allMatchExample() {

        return Arrays.asList(1, 2, 3)
                .stream()
                .allMatch(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer n) {
                        System.out.println("now is " + n);
                        return n >= 1;
                    }
                });
    }

    /**
     * Returns true if at least one element of a stream satisfied to a condition
     */
    public static boolean anyMatchExample() {
        Integer[] arr = {23, 231, 234, 32, 4, 43};
        return Arrays
                .stream(arr)
                .anyMatch(e -> e == 366662);
    }

    /**
     * Returns false if at least one element of a stream satisfied to a condition
     */
    public static boolean noneMatchExample() {
        return Stream
                .of(3, 4, 6, 90)
                .noneMatch((Integer x) -> x == 0);
    }

    /**
     * Concatenation of multiple streams
     */
    public static void concatExample() {
        Stream
                .concat(Arrays.stream(new String[]{"hello", "hi"}),
                        Stream.of("buy", "sell", "bought"))
                .forEach(System.out::println);
    }

    /**
     * Returns length of elements of a stream
     */
    public static void countExample() {
        System.out.println(Stream.of("12ff", "vdvd", "fdsf").count());
    }

    /**
     * Returns a stream of an unique elements
     */
    public static void distinctExample() {
        Consumer<String> consumer = System.out::println;
        Stream.of("hello", "hi", "hi").
                distinct().forEach(consumer);
    }

    /**
     * Getting all strings that don't start with "h"
     */
    public static void filterExample() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Stream.concat(
                Arrays.stream(new String[]{"hello", "hi"}),
                Stream.of("buy")
        ).filter(x -> !x.startsWith("h")).forEach(consumer);
    }

    /**
     * Getting any element from a stream if this one is exist
     */
    public static void findAnyExample() {
        Stream.of(3, 3, 4, 6, 90)
                .filter(x -> x == 3)
                .findAny()
                .ifPresent(System.out::println);
    }

    //** Converting any nested collections to one flat stream */
    public static void flatMapExample() {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("jj", "dsfdsf", "dddd"),
                Arrays.asList("jj2", "ndsbvdbshdbsj", "ddddggg")
        );
        list.stream().flatMap(l -> l.stream()).forEach(System.out::println);
    }

    /**
     * Performing some operation on each of element in order way
     */
    public static void forEachOrderedExample() {
        Stream.of(773, 13, 4, 6, 90).forEachOrdered(System.out::println);
    }

    /**
     * Generating infinitive elements.
     * It should be limited to get final number of elements.
     */
    public static void generateExample() {
        Stream.generate(new Random()::nextDouble)
                .limit(10)
                .forEach(System.out::println);
    }

    /**
     * Generating infinitive elements with some step.
     * It should be limited to get final number of elements.
     */
    public static void iterateExample() {
        Stream<Integer> intStream = Stream.iterate(2, x -> x + 2).limit(10);

        intStream.forEach(System.out::println);
    }

    /**
     * Limiting a stream by number of elements
     */
    public static void limitExample() {
        Stream.of(1, 2, 3, 1, 2, 3, 3, 1, 2, 3)
                .limit(7)
                .forEach(System.out::println);
    }

    /**
     * Converting type of elements to another type and return a new stream
     */
    public static void mapExample() {
        Person person1 = new Person("John", "Doe", 20);
        Person person2 = new Person("Maria", "Doe", 19);
        Person person3 = new Person("Vitaliy", "Tsukerman", 18);

        Stream myStream = Stream.of(person1, person2, person3)
                .filter(p -> p.getSurname().equals("Doe") && p.getName().equals("Maria"))
                .map(p -> {
                    System.out.println("map: " + p.getName());
                    return p.getName();
                });

        myStream.forEach(n -> {
            System.out.println("forEach: " + n);
        });
    }

    /**
     * Getting max element in the stream
     */
    public static void maxExample() {
        Stream.of(1, 43, 33, 12, 9)
                .max(Integer::compare)
                .ifPresent(System.out::println);
    }

    /**
     * Getting min element in the stream
     */
    public static void minExample() {
        Stream.of(1, 43, 33, 12, 9)
                .min(Integer::compare)
                .ifPresent(System.out::println);
    }

    /**
     * Peek - nothing to do special on elements in a stream,
     * but you may specify some operation on each element of the stream
     */

    public static void peekExample() {
        Person person1 = new Person("John", "Doe", 11);
        Person person2 = new Person("Maria", "Doe", 12);
        Person person3 = new Person("Vitaliy", "Tsukerman", 13);

        Stream.of(person1, person2, person3)
                .filter(p -> p.getSurname().equals("Doe"))
                .peek(p -> p.setName("New Name"))
                .map(p -> p.getName())
                .forEach(n -> {
                    System.out.println("forEach: " + n);
                });
    }

    /**
     * Getting of special stream only for Integer element(not generic)
     */
    public static void intStreamExample() {
        Person person1 = new Person("John", "Doe", 11);
        Person person2 = new Person("Maria", "Doe", 12);
        Person person3 = new Person("Vitaliy", "Tsukerman", 13);

        IntStream intStream =
                Stream.of(person1, person2, person3)
                        .mapToInt(p -> p.getSurname().length());

        intStream.forEach(System.out::println);
    }
}
