package com.linkedin.javacodechallenges;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class App 
{
    public static void redactTextFile(String fileName,
                                      String[] redactedWordsArray) {
        BufferedReader reader;
        BufferedWriter writer;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            writer = new BufferedWriter(new FileWriter("redacted_" + fileName));

            String currentLine = reader.readLine();
            while (currentLine != null) {
                System.out.println(currentLine);
                for (String redactedWord : redactedWordsArray) {
                    currentLine = StringUtils
                            .replaceIgnoreCase(currentLine,
                                    redactedWord, "REDACTED");
                }
                writer.append(currentLine).append("\n");
                currentLine = reader.readLine();                
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("What file would you like to " +
                "redact information from? ");
        String fileName = scanner.nextLine();

        System.out.print("What words would you like to redact? " +
                "Separate each word or phrase with a comma. " +
                "If you phrase includes punctuation, include " +
                "that in your input. ");
        String redactedWords = scanner.nextLine();
        String[] redactedWordsList = redactedWords.split(",");

        redactTextFile(fileName, redactedWordsList);

        scanner.close();
    }
}
