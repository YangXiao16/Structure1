package com.example.software1.Method.ObjectOriented;

import java.util.ArrayList;

public class Output {
    private ArrayList<String> list;


    public Output(ArrayList<String> kwicList) {

        this.list = kwicList;
    }

    public String output() {
        return String.join("\n", list);
    }

}

