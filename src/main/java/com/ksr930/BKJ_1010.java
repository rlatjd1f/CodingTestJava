package com.ksr930;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BKJ_1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> resultList = new ArrayList<>();

        int T = sc.nextInt();
        IntStream.range(0, T).forEach(i -> {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int res = getRes(M, N);

            resultList.add(res);
        });

        resultList.forEach(System.out::println);
    }

    private static int getRes(int n, int r) {
        int res = 1;

        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}
