package org.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class infrastructure {

    /**
     * Создание списка целых чисел
     * @param len длина списка
     * @param minNum минимальное значение
     * @param maxNum максимальное значение
     * @return список целых чисел
     */
    static List<Integer> createListNumbers(int len, int minNum, int maxNum) {
        List<Integer> lstNum = new ArrayList<>();
        Random rnd = new Random();
        if (minNum == 0) {
            for (int i = 0; i <= len; i++) {
                lstNum.add(i, rnd.nextInt(maxNum));
            }
        }
        else {
            for (int i = 0; i <= len; i++) {
                lstNum.add(i, rnd.nextInt(maxNum - minNum) + minNum);
            }
        }
        return lstNum;
    }



    /**
     * Удалить все чётные элементы из списка
     * @param numbers входящий список целых чисел
     */
    static void removeEvenNumber(List<Integer> numbers) {

    }

    /**
     * Удалить строки, которые являются целыми числами
     * @param strings входящий список строк
     */
    static void removeIntegers(List<String> strings) {

    }

}