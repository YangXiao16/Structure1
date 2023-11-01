package com.example.software1.Method.ObjectOriented;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {
    private ArrayList<String> lineTxt = new ArrayList<String>();

    public ArrayList<String> getLineTxt() {
        return lineTxt;
    }

    public void input(File file) throws IOException {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = inputFile.readLine()) != null) {
                lineTxt.add(line);
            }
        }
    }

}

