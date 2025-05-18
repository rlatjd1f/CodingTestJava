package com.ksr930;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BKJ_1018 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        String[][] map = new String[N][M];
        IntStream.range(0, N).forEach(n -> {
            String next = sc.next();
            String[] split = next.split("");

            for (int m = 0; m < split.length; m++) {
                map[n][m] = split[m];
            }
        });

        int minCount = N * M;

        for (int y = 0; y <= N - 8; y++) {
            for (int x = 0; x <= M - 8; x++) {
                minCount = Math.min(minCount, colorMap(x, y, map));

            }
        }

        System.out.println(minCount);
    }

    public static int colorMap(int row, int col, String[][] map) {

        int paint1 = 0, paint2 = 0;

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                String exceptedW = ((y + x) % 2) == 0 ? "W" : "B"; // W 시작
                String exceptedB = ((y + x) % 2) == 0 ? "B" : "W"; // B 시작

                String realColor = map[y + col][x + row];

                if (!exceptedW.equals(realColor)) paint1++;
                if (!exceptedB.equals(realColor)) paint2++;
            }
        }

        return Math.min(paint1, paint2);
    }
}
