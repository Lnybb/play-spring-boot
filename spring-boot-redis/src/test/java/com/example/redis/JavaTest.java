package com.example.redis;

import java.util.ArrayList;
import java.util.List;

public class JavaTest {

    private List<Integer> getIntegerArrayList() {
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);

        return integerArrayList;
    }

    void traverseIntegerArrayListByIterator() {
        List<Integer> integerArrayList = getIntegerArrayList();
        for (Integer number : integerArrayList) {
            System.out.println(number);
        }
    }

    void modifyIntegerArrayListByIterator() {
        List<Integer> integerArrayList = getIntegerArrayList();
        for (Integer number : integerArrayList) {
            number = number * number;
        }
    }

    void traverseIntegerArrayListByArrayIndex() {
        List<Integer> integerArrayList = getIntegerArrayList();
        for (int i = 0; i < integerArrayList.size(); i++) {
            System.out.println(integerArrayList.get(i));
        }
    }

}
