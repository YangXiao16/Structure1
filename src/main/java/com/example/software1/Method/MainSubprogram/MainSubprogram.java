package com.example.software1.Method.MainSubprogram;

import java.io.*;
import java.util.*;

public class MainSubprogram {
    private ArrayList<String> kwicList = new ArrayList<String>();
    private ArrayList<String> lineTxt = new ArrayList<String>();

    public static String MS(File file) throws IOException {
        MainSubprogram ms = new MainSubprogram();
        ms.input(file);
        ms.shift();
        ms.alphabetizer();
        return String.join("\n", ms.kwicList);
    }

    public void input(File file) throws IOException {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = inputFile.readLine()) != null) {
                lineTxt.add(line);
            }
        }
    }

    public void output(String filename) throws IOException {
        try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(filename))) {
            for (String s : kwicList) {
                outputFile.write(s + "\n");
            }
        }
    }

    public void shift() {
        for (String s : lineTxt) {
            processLine(s);
        }
    }

    private void processLine(String line) {
        StringTokenizer token = new StringTokenizer(line);
        List<String> tokens = new ArrayList<>();
        int count = token.countTokens();
        for (int i = 0; i < count; i++) {
            tokens.add(token.nextToken());
        }
        for (int i = 0; i < count; i++) {
            StringBuilder lineBuffer = new StringBuilder();
            int index = i;
            for (int f = 0; f < count; f++) {
                if (index >= count)
                    index = 0;
                lineBuffer.append(tokens.get(index));
                lineBuffer.append(" ");
                index++;
            }
            kwicList.add(lineBuffer.toString());
        }
    }

    public void alphabetizer() {
        kwicList.sort(new AlphabetizerComparator());
    }

    private static class AlphabetizerComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null || o2 == null) {
                throw new NullPointerException();
            }
            return Character.compare(o1.toLowerCase().charAt(0), o2.toLowerCase().charAt(0));
        }
    }
}
