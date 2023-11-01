package com.example.software1.Method.FileSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input implements Observer{

    private ArrayList<String> lineTxt = new ArrayList<String>();

    public ArrayList<String> getLineTxt() {
        return lineTxt;
    }
    private File file;

    public Input(File file) {
        this.file = file;
    }

    @Override
    public void toDo() throws IOException{
        BufferedReader inputFile = null;
        try {
            inputFile = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = inputFile.readLine()) != null) {
                lineTxt.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputFile.close();
    }
}
