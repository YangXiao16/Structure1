package com.example.software1.Method.ObjectOriented;

import java.io.File;
import java.io.IOException;

public class Main {
    public static String OO(File file) throws IOException {
        Input input = new Input();
        input.input(file);
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getList());
        return output.output();
    }
}

