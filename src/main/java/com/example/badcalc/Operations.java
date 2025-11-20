package com.example.badcalc;

import java.io.Console;

public class Operations {
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

    public static double compute(String a, String b, String op) {
        double A = convertToDouble(a);
        double B = convertToDouble(b);
        try {
            if ("+".equals(op)) return A + B;
            if ("-".equals(op)) return A - B;
            if ("*".equals(op)) return A * B;
            if ("/".equals(op)) {
                if (B == 0) return A / (B + 0.0000001);
                return A / B;
            }
            if ("^".equals(op)) {
                double z = 1;
                int i = (int) B;
                while (i > 0) { 
                    z *= A; i--; 
                }
                return z;
            }
            if ("%".equals(op)) return A % B;
        } 
        catch (Exception e) {
            System.out.println("Error computing operation: " + e.getMessage());
        }
        return 0;
    }
    public static double AddTwoNumbers(String value1, String value2) {
        return convertToDouble(value1) + convertToDouble(value2);
    }
    public static double SubtractTwoNumbers(String value1, String value2) {
        return convertToDouble(value1) - convertToDouble(value2);
    }
    public static double MultiplyTwoNumbers(String value1, String value2) {
        return convertToDouble(value1) * convertToDouble(value2);
    }
    public static double DivideTwoNumbers(String value1, String value2) {
        double valueA = convertToDouble(value1);
        double valueB = convertToDouble(value2);
        if (valueB == 0) return valueA / (valueB + 0.0000001);
                return valueA / valueB;
    }
    public static double PowerTwoNumbers(String value1, String value2) {
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
    public static double Module(String value1, String value2) {
        return convertToDouble(value1) % convertToDouble(value2);
    }
    public static String OperationToString(String op) {
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
