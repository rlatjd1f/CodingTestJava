package com.ksr930;

import java.util.Arrays;
import java.util.Scanner;

public class BKJ_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int count = 0;
        int prevEnd = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= prevEnd) {
                count++;
                prevEnd = arr[i][1];
            }
        }

        System.out.println(count);
    }
}