package com.ksr930;

import java.util.Scanner;

public class BKJ_1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[][] arr = new int[T][6];

        for (int i = 0; i < T; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            int dx = x2 - x1;
            int dy = y2 - y1;
            double distance = Math.sqrt(dx * dx + dy * dy);

            if (distance == 0 & r1 == r2)
                System.out.println(-1);
            else if (distance == r1 + r2 || distance == Math.abs(r1 - r2))
                System.out.println(1);
            else if (distance < r1 + r2 && distance > Math.abs(r1 - r2))
                System.out.println(2);
            else
                System.out.println(0);
        }

    }
}
