package org.example.java21;

import java.util.FormatProcessor;

public class MainExample {
    public static void main(String[] args) {
        beforeJava21();
        asOfJava21();

        boolean canHaveModifier = Character.isEmojiModifierBase('✋');
        System.out.println(canHaveModifier);
//        boolean isEmojiChar = Character.isEmoji('????');
        System.out.println(interpolationWithExpressions());
        System.out.println(interpolationOfJSONBlock(getFeelsLike(), getTemperature(), getUnit()));
        System.out.println(interpolationOfJSONBlockWithFMT(getFeelsLike(), Float.valueOf(getTemperature()), getUnit()));
    }

    private static void asOfJava21() {
        // As of Java 21
        String productName = "Widget";
        double productPrice = 29.99;
        boolean productAvailable = true;

        String productInfo = STR."Product: \{productName} Price: \{productPrice} Availability: \{productAvailable ? "In Stock" : "Out of Stock"}";

        System.out.println(productInfo);
    }

    private static void beforeJava21() {
        // Prior to Java 21
        String productName = "Widget";
        double productPrice = 29.99;
        boolean productAvailable = true;

        String productInfo = "Product: " + productName + "\nPrice: $" + productPrice + "\nAvailability: " + (productAvailable ? "In Stock" : "Out of Stock");

        System.out.println(productInfo);
    }

    static String interpolationWithExpressions() {
        return STR
                ."Today's weather is \{getFeelsLike()}, with a temperature of \{getTemperature()} degrees \{getUnit()}";
    }

    private static String getUnit() {
        return "34";
    }

    private static String getTemperature() {
        return "22";
    }

    private static String getFeelsLike() {
        return "chill";
    }

    static String interpolationOfJSONBlock(String feelsLike, String temperature, String unit) {
        return STR."""
                  {
                    "feelsLike": "\{feelsLike}",
                    "temperature": "\{temperature}",
                    "unit": "\{unit}"
                  }
                  """;
    }

    static String interpolationOfJSONBlockWithFMT(String feelsLike, float temperature, String unit) {
        return FormatProcessor.FMT."""
                                  {
                                    "feelsLike": "%1s\{feelsLike}",
                                    "temperature": "%2.2f\{temperature}",
                                    "unit": "%1s\{unit}"
                                  }
                                  """;
    }
}
