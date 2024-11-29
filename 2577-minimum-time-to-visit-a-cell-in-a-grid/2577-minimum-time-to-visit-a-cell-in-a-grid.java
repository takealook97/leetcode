import java.util.*;

class Solution {
    static int N, M;
    static int[][] board, dist;
    static int[] dy = {0, 1, 0, -1}, dx = {1, 0, -1, 0};

    static class Point implements Comparable<Point> {
        int y, x, time;

        public Point(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            return this.time - o.time;
        }
    }

    public int minimumTime(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        board = grid;

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        return find();
    }

    static int find() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            if (now.y == N - 1 && now.x == M - 1) {
                return now.time;
            }

            if (now.time > dist[now.y][now.x]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];

                if (!isInRange(nextY, nextX)) {
                    continue;
                }

                int waitTime = 0;
                if (now.time + 1 < board[nextY][nextX]) {
                    waitTime = board[nextY][nextX] - (now.time + 1);
                    if (waitTime % 2 != 0) {
                        waitTime++;
                    }
                }

                int nextTime = now.time + 1 + waitTime;
                if (nextTime < dist[nextY][nextX]) {
                    dist[nextY][nextX] = nextTime;
                    pq.add(new Point(nextY, nextX, nextTime));
                }
            }
        }

        return -1;
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}
