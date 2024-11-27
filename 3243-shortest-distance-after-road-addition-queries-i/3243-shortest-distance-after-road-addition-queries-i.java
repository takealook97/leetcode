class Solution {
    static int n;
    static ArrayList<Integer>[] listArr;
    static Queue<int[]> queue;
    static boolean[] visited;
    static int[] answer;

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        this.n = n;
        listArr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            listArr[i] = new ArrayList<>();
            if (i < n - 1) {
                listArr[i].add(i + 1);
            }
        }

        int len = queries.length;
        answer = new int[len];
        queue = new ArrayDeque<>();
        visited = new boolean[n];

        int idx = 0;
        for (int[] query : queries) {
            listArr[query[0]].add(query[1]);
            answer[idx] = bfs();
            idx++;
        }

        return answer;
    }

    static int bfs() {
        queue.clear();
        Arrays.fill(visited, false);
        queue.add(new int[]{0, 0});
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int node = now[0];
            int count = now[1];

            if (node == n - 1) {
                return count;
            }

            for (int next : listArr[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, count + 1});
                }
            }
        }

        return -1;
    }
}
