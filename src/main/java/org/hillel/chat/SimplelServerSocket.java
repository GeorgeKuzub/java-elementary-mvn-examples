package org.hillel.chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimplelServerSocket {
    public static void main(String[] args) {
        Socket s = null;
        PrintStream ps = null;
        try { // отправка строки клиенту
            // создание объекта и назначение номера порта
            ServerSocket server = new ServerSocket(8030);
            s = server.accept(); // ожидание соединения
            ps = new PrintStream(s.getOutputStream());
            // помещение строки "привет!" в буфер
            ps.println("hello my dear client!");
            // отправка содержимого буфера клиенту
            ps.flush();
        } catch (IOException e) {
            System.err.println("Ошибка соединения потока: " + e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (s != null) {
                try { // разрыв соединения
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}