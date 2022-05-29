package com.stepik.tasks.streamChars;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/*
Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

Пример

InputStream последовательно возвращает четыре байта: 48 49 50 51.

Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
 */

public class Program1 {
    public static void main(String[] args) {

    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder strBuilder = new StringBuilder();

        int cur;
        while((cur = reader.read()) > -1) {
            strBuilder.append((char) cur);
        }

        return strBuilder.toString();
    }
}
