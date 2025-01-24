class Solution {
    static int N;
    static List<Integer>[] listArr;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        N = graph.length;
        listArr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            listArr[i] = new ArrayList<>();
        }

        int[] degree = new int[N];
        for (int from = 0; from < N; from++) {
            for (int to : graph[from]) {
                listArr[to].add(from);
            }
            degree[from] = graph[from].length;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        boolean[] visited = new boolean[N];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            for (int to : listArr[node]) {
                degree[to]--;
                if (degree[to] == 0) {
                    queue.add(to);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                answer.add(i);
            }
        }

        return answer;
    }
}
