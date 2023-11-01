package com.example.software1.Method.ObjectOriented;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Shift {
    private ArrayList<String> kwicList = new ArrayList<String>();
    private ArrayList<String> lineTxt;

    public Shift( ArrayList<String> lineTxt) {
        this.lineTxt = lineTxt;
    }

    public ArrayList<String> getKwicList() {
        return kwicList;
    }

    public void shift() {
        for (String line : lineTxt) {
            StringTokenizer token = new StringTokenizer(line);
            ArrayList<String> tokens = new ArrayList<String>();
            int i = 0;
            int count = token.countTokens();
            while (i < count) {
                tokens.add(token.nextToken());
                i++;
            }

            for (i = 0; i < count; i++) {
                StringBuffer lineBuffer = new StringBuffer();
                int index = i;
                for (int f = 0; f < count; f++) {
                    if (index >= count)
                        index = 0;
                    lineBuffer.append(tokens.get(index));
                    lineBuffer.append(" ");
                    index++;
                }
                String tmp = lineBuffer.toString();
                kwicList.add(tmp);
            }
        }
    }

}
