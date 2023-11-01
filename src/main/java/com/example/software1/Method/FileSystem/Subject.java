package com.example.software1.Method.FileSystem;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Subject {

    private List<Observer> vector = new LinkedList<>();

    public void addObserver(Observer observer) {
        vector.add(observer);
    }

    public void notifyOneObserver(int i) throws IOException{

        vector.get(i).toDo();
    }

}
