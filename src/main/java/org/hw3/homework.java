package org.hw3;

import java.util.List;

public class homework {
    public static void main(String[] args) {
        List<Integer> lst1 = infrastructure.createListNumbers(10, -10, 9);
        System.out.println(lst1);
        List<String> lst2 = infrastructure.createMixedList(10,1, 5);
        System.out.println(lst2);
    }
}