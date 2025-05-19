package com.ksr930;

import java.util.*;
import java.util.stream.IntStream;

public class BKJ_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[M];

        IntStream.range(0, M).forEach(m -> arr[m] = sc.nextInt());

        Deque<Integer> queue = new ArrayDeque<>();
        IntStream.range(1, N + 1).forEach(queue::add);

        int result = 0;

        for (int out : arr) {
            int leftMove = 0;
            int rightMove = 0;

            Deque<Integer> leftQueue = new ArrayDeque<>(queue);
            Deque<Integer> rightQueue = new ArrayDeque<>(queue);

            while (!leftQueue.isEmpty()) {
                Integer peekFront = leftQueue.peekFirst();
                if (peekFront == out) {
                    leftQueue.pollFirst();
                    break;
                } else {
                    leftQueue.addLast(leftQueue.pollFirst());
                    leftMove += 1;
                }
            }

            while (!rightQueue.isEmpty()) {
                Integer peekFront = rightQueue.peekFirst();
                if (peekFront == out) {
                    rightQueue.pollFirst();
                    break;
                } else {
                    rightQueue.addFirst(rightQueue.pollLast());
                    rightMove += 1;
                }
            }

            result += Math.min(leftMove, rightMove);

            if (leftMove > rightMove) {
                queue = new ArrayDeque<>(rightQueue);
            } else {
                queue = new ArrayDeque<>(leftQueue);
            }
        }

        System.out.println(result);
    }
}
