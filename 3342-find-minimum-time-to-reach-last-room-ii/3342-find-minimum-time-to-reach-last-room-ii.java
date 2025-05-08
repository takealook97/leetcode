class Solution {
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    static class Point implements Comparable<Point> {
        int y, x, time;
        boolean check;

        public Point(int y, int x, int time, boolean check) {
            this.y = y;
            this.x = x;
            this.time = time;
            this.check = check;
        }

        @Override
        public int compareTo(Point o) {
            return this.time - o.time;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int N = moveTime.length, M = moveTime[0].length;
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[0][0] = 0;
        pq.add(new Point(0, 0, 0, true));

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            if (now.y == N - 1 && now.x == M - 1) return now.time;
            if (now.time > dist[now.y][now.x]) continue;

            for (int i = 0; i < 4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];
                if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
                    int start = now.time;
                    if (start >= moveTime[nextY][nextX]) {
                        if (now.check) {
                            start += 1;
                        } else {
                            start += 2;
                        }
                    } else {
                        start = moveTime[nextY][nextX];
                        if (now.check) {
                            start += 1;
                        } else {
                            start += 2;
                        }
                    }

                    if (start < dist[nextY][nextX]) {
                        dist[nextY][nextX] = start;
                        pq.add(new Point(nextY, nextX, start, !now.check));
                    }
                }
            }
        }

        return -1;
    }
}
