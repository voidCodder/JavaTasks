package com.stepik.tasks.collections;

import java.util.HashSet;
import java.util.Set;

/*
Реализуйте метод, вычисляющий симметрическую разность двух множеств.

Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

Пример

Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
 */

public class Program1 {
    public static void main(String[] args) {

    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set1Copy = new HashSet<>(set1);
        Set<T> set2Copy = new HashSet<>(set2);
        set1Copy.removeAll(set2);
        set2Copy.removeAll(set1);

        set1Copy.addAll(set2Copy);

        return set1Copy;
    }
}
