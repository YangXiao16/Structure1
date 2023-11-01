package com.example.software1.Method.FileSystem;

import java.io.File;
import java.io.IOException;

public class Main {
    public static String FS(File file) throws IOException {
        KWICSubject kwicSubject = new KWICSubject();
        Input input = new Input(file);
        Shift shift = new Shift(input.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getList(), file);

        // 将观察者加入主题
        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);

        kwicSubject.startKWIC();

        return output.output();
    }
}

