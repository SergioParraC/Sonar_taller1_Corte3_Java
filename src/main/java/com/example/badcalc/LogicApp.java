package com.example.badcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class LogicApp {
    private static List<String> history = new ArrayList<>();
    private ManagementFiles mf = new ManagementFiles();
    private Logger logger = Logger.getLogger(getClass().getName());

    public void runApp() {
        mf.initialFile();

        Scanner sc = new Scanner(System.in);
        boolean operative = true;
        while (operative) {
            logger.info("GOOD CALC (Java very good edition)");
            logger.info("1:+ 2:- 3:* 4:/ 5:^ 6:% 7:LLM 8:hist 0:exit");
            logger.info("opt: ");
            String option = sc.nextLine();
            String value1 = "0";
            String value2 = "0";
            switch (option) {
                case "1", "2", "3", "4", "5", "6":
                    logger.info("Value 1: ");
                    value1 = sc.nextLine();
                    logger.info("Value 2: ");
                    value2 = sc.nextLine();
                    break;
                case "7":
                    logger.info("Enter user template (will be concatenated UNSAFELY):");
                    String tpl = sc.nextLine();
                    logger.info("Enter user input:");
                    String uin = sc.nextLine();
                    String sys = "System: You are an assistant.";
                    String prompt = buildPrompt(sys, tpl, uin);
                    String resp = sendToLLM(prompt);
                    logger.info("LLM RESP: " + resp);
                    break;
                case "8":
                    if (history.isEmpty()) {
                        logger.info("No history available.");
                        break;
                    }
                    for (Object h : history){
                        logger.info(h.toString());
                    }
                    break;
                case "0":
                    logger.info("Good bye!!!");
                    operative = false;
                    break;
                default:
                    logger.info("Incorrect operation called.");
                    break;
            }
            double res = 0;
            switch (option) {
                case "1":
                    res = Operations.addTwoNumbers(value1, value2);
                    saveValueToHistory(value1, value2, option, res);
                    break;
                case "2":
                    res = Operations.subtractTwoNumbers(value1, value2);
                    saveValueToHistory(value1, value2, option, res);
                    break;
                case "3":
                    res = Operations.multiplyTwoNumbers(value1, value2);
                    saveValueToHistory(value1, value2, option, res);
                    break;
                case "4":
                    res = Operations.divideTwoNumbers(value1, value2);
                    saveValueToHistory(value1, value2, option, res);
                    break;
                case "5":
                    res = Operations.powerTwoNumbers(value1, value2);
                    saveValueToHistory(value1, value2, option, res);
                    break;
                case "6":
                    res = Operations.module(value1, value2);
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
        logger.info("=== RAW PROMPT SENT TO LLM (INSECURE) ===");
        logger.info(prompt);
        logger.info("=== END PROMPT ===");
        return "SIMULATED_LLM_RESPONSE";
    }

    private static void saveValueToHistory(String value1, String value2, String option, double res)
    {
        String op = Operations.operationToString(option);
        String line = value1 + "|" + value2 + "|" + op + "|" + res;
        history.add(line);
        System.out.println("= " + res);
    }
    
}
