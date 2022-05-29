package com.stepik.tasks.streamBytes;

import java.io.IOException;
import java.io.InputStream;

/*
Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.

Контрольная сумма данных вычисляется по следующему алгоритму:

Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле: C_{n+1}=\mathrm{rotateLeft}(C_n)\ \mathrm{xor}\ b_{n+1}C
n+1
​
 =rotateLeft(C
n
​
 ) xor b
n+1
​
  , где C_nC
n
​
  — контрольная сумма первых n байт данных, rotateLeft — циклический сдвиг бит числа на один бит влево (чтобы не изобретать велосипед, используйте Integer.rotateLeft), b_nb
n
​
  — n-ный байт данных.
 */

public class Program1 {
    public static void main(String[] args) {

    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int controlSum = 0;
        int byteRead;

        while((byteRead = inputStream.read()) > 0) {
            controlSum = Integer.rotateLeft(controlSum, 1) ^ byteRead;
        }

        return controlSum;
    }

}
