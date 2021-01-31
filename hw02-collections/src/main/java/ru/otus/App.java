package ru.otus;

import java.util.Collections;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {

        int initCap = 100;
        DIYArrayList<Integer> diyList1 = new DIYArrayList<>(initCap);
        DIYArrayList<Integer> diyList2 = new DIYArrayList<>();

        for (int i = 0; i < initCap; i++) {
            diyList1.add(i);
        }

        for (int i = 0; i < 50; i++) {
            diyList2.add(i + 10);
        }

        Collections.copy(diyList1, diyList2);
        Collections.sort(diyList1);
        Collections.addAll(diyList1, diyList2.toArray(new Integer[]{}));


    }

}