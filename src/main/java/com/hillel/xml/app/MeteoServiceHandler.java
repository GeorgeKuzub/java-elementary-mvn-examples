package com.hillel.xml.app;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MeteoServiceHandler extends DefaultHandler {

    // Сюда будем складировать инфу о погоде
    private List<Integer> maxTempList = new ArrayList<>();
    private List<Integer> minTempList = new ArrayList<>();
    private List<LocalDate> dateList = new ArrayList<>();
    private List<Integer> maxPressureList = new ArrayList<>();
    private List<Integer> minPressureList = new ArrayList<>();


    public MeteoServiceHandler() {
        super();
    }


    // Методы, которые мы переопределим

    @Override
    public void startDocument() {
        System.out.println("Getting info about our weather in Odessa...");
    }


    @Override
    public void endDocument() {
        System.out.println("Stop getting the weather.");
    }


    // А тут  и происходит сам парсинг
    @Override
    public void startElement(String uri, String name, String qName, Attributes atts) {
        if (qName.equalsIgnoreCase("FORECAST")) {
            int day = Integer.parseInt(atts.getValue(0));
            System.out.println("Day: " + day);
            int month = Integer.parseInt(atts.getValue(1));
            System.out.println("Month: " + month);
            int year = Integer.parseInt(atts.getValue(2));
            dateList.add(LocalDate.of(year, month, day));
        }

        if (qName.equalsIgnoreCase("TEMPERATURE")) {
            int max = Integer.parseInt(atts.getValue(0));
            System.out.println("maxTempList: " + max);

            int min = Integer.parseInt(atts.getValue(1));
            System.out.println("minTempList: " + min);

            maxTempList.add(max);
            minTempList.add(min);
        }

        if (qName.equalsIgnoreCase("PRESSURE")) {
            int max = Integer.parseInt(atts.getValue(0));
            System.out.println("Max pressure: " + max);
            maxPressureList.add(max);

            int min = Integer.parseInt(atts.getValue(1));
            System.out.println("Min pressure: " + max);
            minPressureList.add(min);
        }
    }
}