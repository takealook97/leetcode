class Solution {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static PriorityQueue<Point> pq;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int answer;

    static final int EMPTY = 0, OBSTACLE = 1;

    static class Point implements Comparable<Point> {
        int y, x, count;

        public Point (int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            return this.count - o.count;
        }

        @Override
        public String toString() {
            return "(" + y + "," + x + " = " + count + ")";
        }
    }

    public int minimumObstacles(int[][] grid) {
        board = grid;
        N = board.length;
        M = board[0].length;
        answer = 0;
        visited = new boolean[N][M];

        findPath();

        return answer;
    }

    static void findPath() {
        pq = new PriorityQueue<>();
        visited[0][0] = true;
        pq.add(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            if(now.y == N - 1 && now.x == M - 1) {
                answer = now.count;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];
                if (isInRange(nextY, nextX) && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;

                    if(board[nextY][nextX] == EMPTY) {
                        pq.add(new Point(nextY, nextX, now.count));
                    } else { // OBSTACLE
                        pq.add(new Point(nextY, nextX, now.count + 1));
                    }
                }
            }
        }

    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}
