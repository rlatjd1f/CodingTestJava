package com.ksr930;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BKJ_1003 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int zeroCount[] = new int[41];
        int oneCount[] = new int[41];

        zeroCount[0] = 1;
        oneCount[0] = 0;
        zeroCount[1] = 0;
        oneCount[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zeroCount[i] = zeroCount[i - 1] + zeroCount[i - 2];
            oneCount[i] = oneCount[i - 1] + oneCount[i - 2];
        }

        int T = sc.nextInt();
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            inputList.add(sc.nextInt());
        }

        inputList.forEach(s -> {
            System.out.printf("%d %d\n", zeroCount[s], oneCount[s]);
        });
    }
}
