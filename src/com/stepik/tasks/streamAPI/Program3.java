package com.stepik.tasks.streamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов.

Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.

Если в тексте меньше 10 уникальных слов, то выводите сколько есть.

Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.

Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.
 */

public class Program3 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {

            in.lines()
                    .flatMap(line -> Stream.of(line.split("[\\p{Punct}\\s]+")))
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(descendingFrequencyOrder())
                    .limit(10)
                    .map(Map.Entry::getKey)
                    .forEach(System.out::println);
        }
    }

    private static Comparator<Map.Entry<String, Long>> descendingFrequencyOrder() {
        return Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }
}

