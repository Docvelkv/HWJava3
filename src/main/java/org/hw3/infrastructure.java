package org.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class infrastructure {

    /**
     * Создание списка целых чисел
     * @param len длина списка
     * @param minNum минимальное значение
     * @param maxNum максимальное значение
     * @return список целых чисел
     */
    public static List<Integer> createListNumbers(int len , int minNum, int maxNum) {
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
     * Создание смешанного списка строк. Строки могут содержать символы или числа
     * @param len длина списка
     * @param minStr минимальное количество символов в одном элементе
     * @param maxStr максимальное количество символов в одном элементе
     * @return смешанный список
     */
    public static List<String> createMixedList(int len, int minStr, int maxStr) {

        Random rnd = new Random();
        int strRatio = rnd.nextInt(10);
        int lenStr = len / 10 * strRatio;
        int lenNum = len - lenStr;
        List<String> tmpNum = new ArrayList<>();
        for (int i = 0; i < lenNum; i++) {
            int lenElement = rnd.nextInt(maxStr - minStr) + minStr;
            int num = 0;
            for (int j = 0; j <= lenElement; j++) {
                num = num * 10 + rnd.nextInt(9);
            }
            num = num * (rnd.nextBoolean() ? -1 : 1);
            tmpNum.add(String.format("%d", num));
        }
        List<Character> lstSymbols = new ArrayList<>();
        Collections.addAll(lstSymbols, 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z');
        List<String> tmpStr = new ArrayList<>();
        for (int i = 0; i < lenStr; i++) {
            int lenElement = rnd.nextInt(maxStr - minStr) + minStr;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= lenElement; j++) {
                int num = rnd.nextInt(26);
                sb.append(lstSymbols.get(num));
            }
            tmpStr.add(sb.toString());
        }
        List<String> result = new ArrayList<>();
        result.addAll(tmpStr);
        result.addAll(lenStr, tmpNum);
        Collections.shuffle(result);
        return result;
    }

    /**
     * Удалить все чётные элементы из списка
     * @param numbers входящий список целых чисел
     */
    static void removeEvenNumber(List<Integer> numbers) {
        numbers.removeIf(x -> x % 2 == 0);
        System.out.println(numbers);
    }

    /**
     * Проверка строки на соответствие целому числу
     * через метод Integer.parseInt()
     * @param str входящая строка
     * @return да или нет
     */
    static boolean tryParseInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Проверка строки на соответствие шаблону
     * @param str входящая строка
     * @param regexStr строка регулярного выражения
     * @return да или нет
     */
    public static boolean matchRegex(String str, String regexStr) {
        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    /**
     * Удалить строки, которые являются целыми числами
     * @param strings входящий список строк
     * @param variant метод поиска соответствия:
     *  1 - метод Integer.parseInt
     *  2 - регулярное выражение "-?\\d+"
     */
    public static void removeIntegers(List<String> strings, int variant) {
        switch (variant) {
            case 1 -> {
                strings.removeIf(infrastructure::tryParseInt);
                System.out.println(strings);
            }
            case 2 -> {
                strings.removeIf(x -> infrastructure.matchRegex(x, "-?\\d+"));
                System.out.println(strings);
            }
        }
    }
}