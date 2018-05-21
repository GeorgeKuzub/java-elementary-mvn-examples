package com.hillel.io.serial;

import com.hillel.io.serial.entities.User;

import java.io.*;

public class Writer {
    private User user;

    public Writer(User user) {
        this.user = user;
    }

    public void write() {
        try (
                FileOutputStream fous = new FileOutputStream("res/out.dat");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fous);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        ) {

            objectOutputStream.writeObject(user);

        } catch (FileNotFoundException e) {
            System.err.println("File wasn't found. Look details below:");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O error was occurred unexpectedly.");
            e.printStackTrace();
        }
    }
}
