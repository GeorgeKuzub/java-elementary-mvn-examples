package com.hillel.stream_intro;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> listUser =
                Arrays.asList(
                        new User("Jhon"),
                        new User("Denis"),
                        new User("Jane"),
                        new User("Elizabet"),
                        new User("Tom")
                );

        listUser.stream()
                .filter(u -> u.getName().startsWith("J"))
                .forEach(System.out::println); // .forEach(u -> System.out.println(u));

//

    }
}
