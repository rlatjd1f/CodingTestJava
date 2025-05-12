package com.ksr930;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BKJ_1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        List<Integer> resultList = new ArrayList<>();

        IntStream.range(0, T).forEach(i -> {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int[] rs = new int[4];
            rs[0] = (a) % 10;
            rs[1] = (a * a) % 10;
            rs[2] = (a * a * a) % 10;
            rs[3] = (a * a * a * a) % 10;

            int c = b % 4 - 1;
            if (c == -1)
                c = 3;

            int res = rs[c];
            if (res == 0)
                res = 10;

            resultList.add(res);
        });

        resultList.forEach(System.out::println);
    }
}
