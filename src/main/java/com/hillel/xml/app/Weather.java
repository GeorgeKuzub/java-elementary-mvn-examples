package com.hillel.xml.app;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class Weather {

    // Шаблон URL для получения погоды
    // Описание сервиса здесь https://www.meteoservice.ru/content/export
    public static final String URL_SOURCE = "https://xml.meteoservice.ru/export/gismeteo/point/55.xml";


    public static void main(String[] args) {
        try {
            // Получаем URL-объект из String
            URL urlObject = new URL(URL_SOURCE);

            // Получаем InputStream (респонс GET-запроса по здананному URL)
            InputStream in = urlObject.openStream();

            // Создаем xml-reader
            XMLReader xr = XMLReaderFactory.createXMLReader();

            // Передаём XML-ридеру инфу о нашем хендлере, который мы научили обрабатывать xml
            MeteoServiceHandler ourSpecialHandler = new MeteoServiceHandler();
            xr.setContentHandler(ourSpecialHandler);

            // Оборачиваем в InputSource, т.к SAX-парсеру нужен именно InputSource
            InputSource inSource = new InputSource(in);

            // Парсим...
            xr.parse(inSource);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        }
    }
}
