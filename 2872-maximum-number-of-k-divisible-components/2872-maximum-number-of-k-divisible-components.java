import java.util.*;

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int[] result = new int[1];
        find(0, -1, list, values, k, visited, result);
        
        return result[0];
    }

    static long find(int node, int parent, List<List<Integer>> list, int[] values, int k, boolean[] visited, int[] result) {
        visited[node] = true;
        long sum = values[node];

        for (int next : list.get(node)) {
            if (next == parent || visited[next]) continue;
            sum += find(next, node, list, values, k, visited, result);
        }

        if (sum % k == 0) {
            result[0]++;
            return 0;
        }

        return sum;
    }
}
