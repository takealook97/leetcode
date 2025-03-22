class Solution {
    static int len;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Integer> queue;
    static List<Integer> list;

    public int countCompleteComponents(int n, int[][] edges) {
        len = n;
        arr = new int[len][len];
        visited = new boolean[len];
        queue = new ArrayDeque<>();
        list = new ArrayList<>();

        for (int[] edge : edges) {
            arr[edge[0]][edge[1]] = 1;
            arr[edge[1]][edge[0]] = 1;
        }

        int answer = 0;
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                if (isPossible(i)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    static boolean isPossible(int start) {
        queue.clear();
        list.clear();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            list.add(now);
            for (int next = 0; next < len; next++) {
                if (arr[now][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int from = list.get(i);
                int to = list.get(j);
                if (arr[from][to] != 1 || arr[to][from] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
