class Solution {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dy = {0, 0, 0, 1, -1}, dx = {0, 1, -1, 0, 0}; // RLDU
    static int answer;

    public int minCost(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        M = grid[0].length;
        visited = new boolean[N][M];
        answer = Integer.MAX_VALUE;
        find(0, 0, 0);
        return answer;
    }

    static void find(int y, int x, int cost) {
        if (y == N - 1 && x == M - 1) {
            answer = Math.min(answer, cost);
            return;
        }

        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;
        int nextY = y + dy[grid[y][x]];
        int nextX = x + dx[grid[y][x]];

        if (isInRange(nextY, nextX) && !visited[nextY][nextX]) {
            find(nextY, nextX, cost);
        }

        for (int i = 1; i <= 4; i++) {
            if (i != grid[y][x]) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (isInRange(newY, newX) && !visited[newY][newX]) {
                    int temp = grid[y][x];
                    grid[y][x] = i;
                    find(newY, newX, cost + 1);
                    grid[y][x] = temp;
                }
            }
        }

        visited[y][x] = false;
    }

    static boolean isInRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}
