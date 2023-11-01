package com.example.software1.Method.FileSystem;

import java.io.IOException;

public class KWICSubject extends Subject{
    public void startKWIC() throws IOException {
        for (int i = 0;i<4;i++){
            super.notifyOneObserver(i);
        }
    }
}

