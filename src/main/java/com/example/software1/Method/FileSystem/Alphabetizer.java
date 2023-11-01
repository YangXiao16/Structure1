package com.example.software1.Method.FileSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Alphabetizer implements Observer, Serializable {
    private static final long serialVersionUID = 1L;

    // 存储字符串的列表
    private ArrayList<String> list;

    public Alphabetizer(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> getList() {
        return list;
    }

    @Override
    public void toDo() {
        Collections.sort(this.list, new AlphabetizerComparator());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alphabetizer that = (Alphabetizer) o;
        return Objects.equals(list, that.list);
    }


    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    private static class AlphabetizerComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null && o2 == null) {
                throw new NullPointerException();
            }
            int compareValue = 0;
            char o1c = o1.toLowerCase().charAt(0); //忽略大小写
            char o2c = o2.toLowerCase().charAt(0); //忽略大小写
            compareValue = o1c - o2c;
            return compareValue;

        }

    }

}

