package com.stepik.tasks.streamChars;

import java.util.Locale;
import java.util.Scanner;

/*
Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в тексте вещественных чисел с точностью до шестого знака после запятой. Числом считается последовательность символов, отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.

На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main — таково ограничение проверяющей системы), метод main, прописать все import'ы.
 */

public class Program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0.0;

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
            } else {
                scanner.next();
            }
        }

        System.out.printf(Locale.ENGLISH, "%.6f", sum);
    }
}
