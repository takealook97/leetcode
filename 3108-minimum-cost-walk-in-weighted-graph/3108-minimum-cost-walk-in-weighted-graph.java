import java.util.*;

class Solution {
    static List<Edge>[] listArr;
    static int[] component;
    static int[] minAndValue;
    static PriorityQueue<Edge> pq;
    static Queue<Integer> queue;

    static class Edge {
        int node, weight;
        
        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        listArr = new ArrayList[n];
        pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        queue = new LinkedList<>();
        component = new int[n];
        minAndValue = new int[n];

        Arrays.fill(component, -1);
        Arrays.fill(minAndValue, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            listArr[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            listArr[from].add(new Edge(to, weight));
            listArr[to].add(new Edge(from, weight));
        }

        int componentId = 0;
        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                bfs(i, componentId++);
            }
        }

        int len = query.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            int start = query[i][0], end = query[i][1];

            if (component[start] == component[end]) {
                answer[i] = minAndValue[component[start]];
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }

    static void bfs(int start, int componentId) {
        queue.clear();
        queue.add(start);
        component[start] = componentId;
        int andValue = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Edge next : listArr[node]) {
                if (component[next.node] == -1) {
                    component[next.node] = componentId;
                    queue.add(next.node);
                }
                andValue &= next.weight;
            }
        }
        minAndValue[componentId] = andValue;
    }
}
