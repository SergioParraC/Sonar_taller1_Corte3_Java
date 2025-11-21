package com.example.badcalc;

public class Operations {
    private Operations() {
        throw new IllegalStateException("Utility class");
    }
    public static double convertToDouble(String s) {
        try {
            if (s == null) return 0;
            s = s.replace(',', '.').trim();
            return Double.parseDouble(s);
        } catch (Exception ex) {
            System.out.println("Error parsing number, please intro a numeric value: " + ex.getMessage());
            return 0;
        }
    }
    public static double addTwoNumbers(String value1, String value2) {
        return convertToDouble(value1) + convertToDouble(value2);
    }
    public static double subtractTwoNumbers(String value1, String value2) {
        return convertToDouble(value1) - convertToDouble(value2);
    }
    public static double multiplyTwoNumbers(String value1, String value2) {
        return convertToDouble(value1) * convertToDouble(value2);
    }
    public static double divideTwoNumbers(String value1, String value2) {
        double valueA = convertToDouble(value1);
        double valueB = convertToDouble(value2);
        if (valueB == 0) {
            return valueA / (valueB + 0.0000001);
        } 
        else {
            return valueA / valueB;
        }
    }
    public static double powerTwoNumbers(String value1, String value2) {
        double base = convertToDouble(value1);
        double exponent = convertToDouble(value2);
        double result = 1;
        int expInt = (int) exponent;
        while (expInt > 0) { 
            result *= base; 
            expInt--; 
        }
        return result;
    }
    public static double module(String value1, String value2) {
        return convertToDouble(value1) % convertToDouble(value2);
    }
    public static String operationToString(String op) {
        switch (op) {
            case "1": return "+";
            case "2": return "-";
            case "3": return "*";
            case "4": return "/";
            case "5": return "^";
            case "6": return "%";
            default: return "?";
        }
    }
}
