package com.ksr930;

import java.util.Scanner;

public class BKJ_1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        for (int i = L; i <= 100; i++) {
            int tmp = N - i * (i - 1) / 2;
            if (tmp < 0)
                break;
            if (tmp % i == 0) {
                int start = tmp / i;

                for (int k = 0; k < i; k++) {
                    System.out.printf("%d ", start + k);
                }
                return;
            }
        }
        System.out.println(-1);
    }
}
