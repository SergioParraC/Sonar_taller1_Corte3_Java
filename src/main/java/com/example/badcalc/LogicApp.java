package com.example.badcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogicApp {
    private static List<String> history = new ArrayList<>();
    private ManagementFiles mf = new ManagementFiles();
    private Operations oprate = new Operations();

    public void runApp() {
        mf.initialFile();

        Scanner sc = new Scanner(System.in);
        boolean operative = true;
        while (operative) {
            System.out.println("GOOD CALC (Java very good edition)");
            System.out.println("1:+ 2:- 3:* 4:/ 5:^ 6:% 7:LLM 8:hist 0:exit");
            System.out.print("opt: ");
            String option = sc.nextLine();
            String value1 = "0";
            String value2 = "0";
            switch (option) {
                case "1", "2", "3", "4", "5", "6":
                    System.out.print("Value 1: ");
                    value1 = sc.nextLine();
                    System.out.print("Value 2: ");
                    value2 = sc.nextLine();
                    break;
                case "7":
                    System.out.print("Enter user template (will be concatenated UNSAFELY): ");
                    String tpl = sc.nextLine();
                    System.out.print("Enter user input: ");
                    String uin = sc.nextLine();
                    String sys = "System: You are an assistant.";
                    String prompt = buildPrompt(sys, tpl, uin);
                    String resp = sendToLLM(prompt);
                    System.out.println(String.format("LLM RESP: %s", resp));
                    break;
                case "8":
                    if (history.isEmpty()) {
                        System.out.println("No history available.");
                        break;
                    }
                    for (Object h : history){
                        System.out.println(h.toString());
                    }
                    break;
                case "0":
                    System.out.print("Good bye!!!");
                    operative = false;
                    break;
                default:
                    System.out.println("Incorrect operation called.");
                    break;
            }
            double res = 0;
            switch (option) {
                case "1":
                    res = oprate.addTwoNumbers(value1, value2);
                    saveValueToHistory(value1, value2, option, res);
                    break;
                case "2":
                    res = oprate.subtractTwoNumbers(value1, value2);
                    saveValueToHistory(value1, value2, option, res);
                    break;
                case "3":
                    res = oprate.multiplyTwoNumbers(value1, value2);
                    saveValueToHistory(value1, value2, option, res);
                    break;
                case "4":
                    res = oprate.divideTwoNumbers(value1, value2);
                    saveValueToHistory(value1, value2, option, res);
                    break;
                case "5":
                    res = oprate.powerTwoNumbers(value1, value2);
                    saveValueToHistory(value1, value2, option, res);
                    break;
                case "6":
                    res = oprate.module(value1, value2);
                    saveValueToHistory(value1, value2, option, res);
                    break;
                case "7", "8", "0":
                    break;
                default: 
                    System.out.println("No operation performed.");
                break;
            }
        }
        mf.saveLastSession(history);
        mf.saveCompleteHistory(history);
        sc.close();
    }
    

    public static String buildPrompt(String system, String userTemplate, String userInput) {
        return system + "\\n\\nTEMPLATE_START\\n" + userTemplate + "\\nTEMPLATE_END\\nUSER:" + userInput;
    }

    public String sendToLLM(String prompt) {
        System.out.println("=== RAW PROMPT SENT TO LLM (INSECURE) ===");
        System.out.println(prompt);
        System.out.println("=== END PROMPT ===");
        return "SIMULATED_LLM_RESPONSE";
    }

    private void saveValueToHistory(String value1, String value2, String option, double res)
    {
        String op = Operations.operationToString(option);
        String line = value1 + "|" + value2 + "|" + op + "|" + res;
        history.add(line);
        System.out.println(String.format("= %s", res));
    }
    
}
