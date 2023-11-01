package com.example.software1.Method.Filefilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static String ToString(File file) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                if (result==""){
                    result =  s;
                }else {
                    result = result + "\n" + s;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String FF(File file) throws IOException {
        File outFile = new File("C:\\Users\\yx\\Desktop\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(file, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile, pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();

        return ToString(outFile);
    }
}

