class Solution {
    static int N, M, len;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static Map<Integer, Integer> map;
    static int[] keyArr;


    static class Point implements Comparable<Point> {
        int y, x, val;

        public Point(int y, int x, int val) {
            this.y = y;
            this.x = x;
            this.val = val;
        }

        @Override
        public int compareTo(Point o) {
            return this.val - o.val;
        }
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        N = grid.length;
        M = grid[0].length;
        this.board = grid;
        visited = new boolean[N][M];
        map = new HashMap<>();
        map.put(0, 0);

        find();
        setKeyArray();

        int queryLen = queries.length;
        int[] answer = new int[queryLen];
        int idx = 0;
        for (int query : queries) {
            answer[idx++] = getResult(query);
        }

        return answer;
    }

    static void find() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, board[0][0]));
        visited[0][0] = true;
        int count = 0;
        int limit = board[0][0];

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            if (now.val > limit) {
                map.put(limit, count);
                limit = now.val;
            }
            count++;

            for (int i = 0; i < 4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];
                if (isPossible(nextY, nextX)) {
                    visited[nextY][nextX] = true;
                    pq.add(new Point(nextY, nextX, board[nextY][nextX]));
                }
            }
        }
        map.put(limit, count);
    }

    static boolean isPossible(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M && !visited[y][x];
    }

    static void setKeyArray() {
        len = map.size();
        keyArr = new int[len];
        int idx = 0;
        for (int key : map.keySet()) {
            keyArr[idx++] = key;
        }

        Arrays.sort(keyArr);
    }

    static int getResult(int query) {
        int resultIdx = lowerBound(query) - 1;
        return map.get(keyArr[resultIdx]);
    }

    static int lowerBound(int target) {
        int lo = 0, hi = len - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (keyArr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
