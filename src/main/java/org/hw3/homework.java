package org.hw3;

import java.util.List;

public class homework {
    public static void main(String[] args) {
        List<Integer> lst1 = infrastructure.createListNumbers(10, -10, 9);
        System.out.println(lst1);
        infrastructure.removeEvenNumber(lst1);
        List<String> lst2 = infrastructure.createMixedList(10,1, 5);
        System.out.println(lst2);
        infrastructure.removeIntegers(lst2, 1);
        List<String> lst3 = infrastructure.createMixedList(15,2, 4);
        System.out.println(lst3);
        infrastructure.removeIntegers(lst3, 2);
    }
}