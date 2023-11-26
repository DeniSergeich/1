package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\serob\\OneDrive\\Рабочий стол\\Мой склад\\MyWarehouse\\src\\1.txt";
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(lines.size());

        for (int i = 0; i < lines.size(); i++) {
            String newValue = lines.get(i).replaceAll("[.\\-/]", "");
            lines.set(i, newValue);
        }

        System.out.println(lines.size());

        for (String x:lines) {
            System.out.println(x);
        }

        try {
            int count = 0;
            FileWriter writer = new FileWriter("2.txt");
            for (String x: lines) {
                writer.write(x + "\n");
                count++;
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}