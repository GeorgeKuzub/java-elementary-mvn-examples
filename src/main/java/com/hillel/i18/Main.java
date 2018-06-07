package com.hillel.i18;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {

        Locale rus = new Locale("ru", "RU");

        ResourceBundle defaultResourceBundle = ResourceBundle.getBundle("message");

        ResourceBundle resourceBundleRu = ResourceBundle.getBundle("message",
                new Locale("ru"));


        System.out.println(defaultResourceBundle.getString("title"));

        System.out.println(resourceBundleRu.getString("title"));

    }

    private static void showCurrentLocal() {
        Locale current = Locale.getDefault();

        System.out.println(current.getCountry());
        System.out.println(current.getDisplayCountry());
        System.out.println(current.getLanguage());
        System.out.println(current.getDisplayLanguage());
    }
}
