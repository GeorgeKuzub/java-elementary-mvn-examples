package org.hillel.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClientSocket {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 8030);

            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {

                String messageRequest = "Hello my dear Server";
                out.write(messageRequest.getBytes());
                out.flush();

                byte[] messageResponse = new byte[in.available()];
                int readBytes = in.read(messageResponse);

                System.out.println("Server response me: " +
                        new String(messageResponse, 0, readBytes));

            }

        } catch (IOException e) {
            System.err.println("ошибка: " + e);
        }
    }
}
