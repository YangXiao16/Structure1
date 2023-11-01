package com.example.software1.Method.FileSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Output implements Observer {
    private ArrayList<String> list;
    private BufferedWriter outputFile;
    private File file;
    public Output(ArrayList<String> list, File file) {
        this.list = list;
        this.file = file;
    }

    @Override
    public void toDo(){
        Iterator<String> it = list.iterator();
        try {
            outputFile = new BufferedWriter(new FileWriter(file));
            while (it.hasNext()) {
                outputFile.write(it.next()+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (outputFile!=null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String output() {
        Iterator<String> it = list.iterator();
        StringBuilder fileContent = new StringBuilder();

        while (it.hasNext()) {
            fileContent.append(it.next()).append("\n");
        }

        return fileContent.toString();
    }

}

