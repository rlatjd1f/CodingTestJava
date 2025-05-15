package com.ksr930;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.LongStream;

public class BKJ_1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long min = sc.nextLong();
        long max = sc.nextLong();

        int count = (int) (max - min + 1);
        Set<Long> set = new HashSet<>();

        LongStream.range(2, (int) Math.sqrt((double) max) + 1).forEach(l -> {
            long square = l * l;
            long start_num = ((min + square - 1) / square) * square;

            for (long k = start_num; k >= min && k <= max; k += square) {
                set.add(k);
            }
        });

        System.out.println(count - set.size());

    }
}
