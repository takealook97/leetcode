class Solution {
    static int N, M;
    static int[][] heightMap;
    static boolean[][] visited;
    static PriorityQueue<Point> pq;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    static class Point implements Comparable<Point> {
        int y, x, z;

        public Point(int y, int x, int z) {
            this.y = y;
            this.x = x;
            this.z = z;
        }

        @Override
        public int compareTo(Point o) {
            return this.z - o.z;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        this.heightMap = heightMap;
        N = heightMap.length;
        M = heightMap[0].length;

        if (N <= 2 || M <= 2) {
            return 0;
        }

        pq = new PriorityQueue<>();
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            pq.add(new Point(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            pq.add(new Point(i, M - 1, heightMap[i][M - 1]));
            visited[i][M - 1] = true;
        }

        for (int j = 0; j < M; j++) {
            pq.add(new Point(0, j, heightMap[0][j]));
            visited[0][j] = true;
            pq.add(new Point(N - 1, j, heightMap[N - 1][j]));
            visited[N - 1][j] = true;
        }

        return find();
    }

    static int find() {
        int answer = 0;

        while (!pq.isEmpty()) {
            Point point = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = point.y + dy[i];
                int nextX = point.x + dx[i];

                if (isInRange(nextY, nextX) && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    answer += Math.max(0, point.z - heightMap[nextY][nextX]);
                    pq.add(new Point(nextY, nextX, Math.max(heightMap[nextY][nextX], point.z)));
                }
            }
        }

        return answer;
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}
