package com.hillel.lambda3;

import com.hillel.lambda2.Person;

public class Starter {
    User uBuilder;

    public static void main(String[] args) {

        UserBuilder userCreator = User::new; // Reference to the constructor

        Person p = new Person("Manger", 1D); // some person
        globalCreator(userCreator, "SysAdm", p);
    }


    public static void globalCreator(UserBuilder builder, String name, Person p) {
//        Logging
//        if (p.getPermission().get("privacy").isPermit()) {
//            return  builder.create(name);
//        }
    }
}