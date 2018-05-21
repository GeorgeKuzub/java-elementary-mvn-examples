package com.hillel.io.serial;

import com.hillel.io.serial.entities.User;

import java.io.*;

public class Reader {
    private File file;

    public Reader(String fileName) {
        this(new File(fileName));
    }

    public Reader(File file) {
        this.file = file;
    }

    public User read() {
        User restoredUser = new User();

        try (FileInputStream fin = new FileInputStream(file);
             ObjectInputStream objInStream = new ObjectInputStream(fin)) {

            restoredUser = (User) objInStream.readObject();

        } catch (FileNotFoundException e) {
            System.err.println("File wasn't found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O error was occurred unexpectedly.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("User class wasn't found by JVM.");
            e.printStackTrace();
        }
        return restoredUser;
    }
}
