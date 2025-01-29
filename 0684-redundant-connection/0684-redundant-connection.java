import java.util.*;

class Solution {
    static boolean isLoop;
    static ArrayList<Integer>[] listArr;
    static ArrayList<Integer> path;
    static boolean[] visited;

    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;

        listArr = new ArrayList[len + 1];
        for (int i = 1; i <= len; i++) {
            listArr[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            visited = new boolean[len + 1];
            path = new ArrayList<>();
            isLoop = false;

            if (!listArr[u].isEmpty() && !listArr[v].isEmpty()) {
                if (find(u, -1, v)) {
                    return edge;
                }
            }

            listArr[u].add(v);
            listArr[v].add(u);
        }

        return null;
    }

    static boolean find(int now, int parent, int target) {
        if (now == target) {
            isLoop = true;
            path.add(now);
            return true;
        }

        visited[now] = true;
        for (int next : listArr[now]) {
            if (next == parent) continue;
            if (!visited[next]) {
                if (find(next, now, target)) {
                    path.add(now);
                    return true;
                }
            }
        }
        return false;
    }
}
