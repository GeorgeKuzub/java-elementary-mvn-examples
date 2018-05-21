package com.hillel.serial;

import com.hillel.serial.entities.Auth;
import com.hillel.serial.entities.User;

public class MainClient {
    public static void main(String[] args) {
        User user = new User(1, "Yurii", "Gagarin");
        Auth auth = new Auth("root", "root");
        user.setAuth(auth);

        Writer writer = new Writer(user);
        writer.write();

        User restoredUser = new Reader("res/out.dat").read();
        System.out.println(restoredUser);
    }
}
