package org.hillel.chat;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Examples {
    public static void main(String[] args) throws UnknownHostException {

        getUrlConnection();


//        getMyIPadress();
//        createIP();

    }

    private static void getUrlConnection() {
        String urlName = "https://www.oracle.com";
        int timeout = 10_000;
        URL url;
        try {
            url = new URL(urlName);
            final URLConnection connection = url.openConnection();
            // установка таймаута на соединение
            connection.setConnectTimeout(timeout);
            InputStream is = connection.getInputStream();

            BufferedInputStream bin = new BufferedInputStream(is);
            byte[] buffer = new byte[bin.available()];
            // считаем файл в буфер
            bin.read(buffer, 0, buffer.length);

            System.out.println(" data:");
            for (int i = 0; i < buffer.length; i++) {
                System.out.print((char) buffer[i]);
            }


            // продолжение извлечения информации из соединения
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createIP() {
        byte ip[] = {(byte) 33, (byte) 235, (byte) 255, (byte) 43};
        try {
            InetAddress addr = InetAddress.getByAddress("[omr.gov.ua]", ip);
            System.out.println(addr.getHostName() + "-> cоединение:"
                    + addr.isReachable(2000));
        } catch (UnknownHostException e) {
            System.err.println("адрес недоступен " + e);
        } catch (IOException e) {
            System.err.println("ошибка потока " + e);
        }
    }

    private static void getMyIPadress() {
        InetAddress currentIP = null;
        InetAddress bsuIP = null;
        try {
            currentIP = InetAddress.getLocalHost();
            // вывод IP-адреса локального компьютера
            System.out.println("Мой IP -> " + currentIP.getHostAddress());
            bsuIP = InetAddress.getByName("www.google.com");
            // вывод IP-адреса www.google.com
            System.out.println("google -> " + bsuIP.getHostAddress());
        } catch (UnknownHostException e) {
            // если не удается найти IP
            System.err.println("адрес недоступен " + e);
        }
    }


}
