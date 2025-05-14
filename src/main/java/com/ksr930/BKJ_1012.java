package com.ksr930;

import java.util.*;
import java.util.stream.IntStream;

public class BKJ_1012 {

    private static final List<Integer> dx = Arrays.asList(0, -1, 0, 1);
    private static final List<Integer> dy = Arrays.asList(1, 0, -1, 0);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            int M = sc.nextInt(); // x
            int N = sc.nextInt(); // y
            int K = sc.nextInt();

            int[][] arr = new int[N][M];
            boolean[][] visit = new boolean[N][M];

            IntStream.range(0, N).forEach(n -> IntStream.range(0, M).forEach(m -> {
                arr[n][m] = 0;
                visit[n][m] = false;
            }));

            IntStream.range(0, K).forEach(t -> {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[y][x] = 1;
            });

            int result = 0;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (arr[y][x] == 1 && !visit[y][x]) {
                        result += 1;
                        visit[y][x] = true;
                        bfs(x, y, arr, visit);
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void bfs(int x, int y, int[][] arr, boolean[][] visit) {
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(Arrays.asList(x, y));

        while (!queue.isEmpty()) {
            List<Integer> pQueue = queue.poll();
            int cx = pQueue.get(0);
            int cy = pQueue.get(1);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx.get(i);
                int ny = cy + dy.get(i);

                if (-1 < nx && nx < arr[0].length && -1 < ny && ny < arr.length) {
                    if (arr[ny][nx] == 1 && !visit[ny][nx]) {
                        visit[ny][nx] = true;
                        queue.add(Arrays.asList(nx, ny));
                    }
                }
            }
        }
    }
}
