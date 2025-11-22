package com.example.badcalc;

public class Operations {
    // Método que convierte un string a double, manejando errores
    public double convertToDouble(String s) {
        try {
            if (s == null) return 0;
            s = s.replace(',', '.').trim();
            return Double.parseDouble(s);
        } catch (Exception ex) {
            System.out.print("Error parsing number, please intro a numeric value: " + ex.getMessage());
            return 0;
        }
    }
    // Métodos de operaciones

    // Suma
    public double addTwoNumbers(String value1, String value2) {
        return convertToDouble(value1) + convertToDouble(value2);
    }
    // Resta
    public double subtractTwoNumbers(String value1, String value2) {
        return convertToDouble(value1) - convertToDouble(value2);
    }
    // Multiplicación
    public double multiplyTwoNumbers(String value1, String value2) {
        return convertToDouble(value1) * convertToDouble(value2);
    }
    // División
    public double divideTwoNumbers(String value1, String value2) {
        double valueA = convertToDouble(value1);
        double valueB = convertToDouble(value2);
        if (valueB == 0) {
            return valueA / (valueB + 0.0000001);
        } 
        else {
            return valueA / valueB;
        }
    }
    // Potenciación
    public double powerTwoNumbers(String value1, String value2) {
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
    // Módulo
    public double module(String value1, String value2) {
        return convertToDouble(value1) % convertToDouble(value2);
    }
    // Método que convierte la opción de operación a su representación en string
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

