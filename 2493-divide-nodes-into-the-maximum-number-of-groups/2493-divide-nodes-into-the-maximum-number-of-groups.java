class Solution {
    static int len;
    static int[] parent;
    static ArrayList<Integer>[] listArr;

    public int magnificentSets(int n, int[][] edges) {
        len = n;
        listArr = new ArrayList[len + 1];
        for (int i = 1; i <= len; i++) {
            listArr[i] = new ArrayList<>();
        }

        make();

        for (int[] edge : edges) {
            listArr[edge[0]].add(edge[1]);
            listArr[edge[1]].add(edge[0]);
            union(edge[0], edge[1]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int root = find(i);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(i);
        }

        int answer = 0;

        for (List<Integer> list : map.values()) {
            int max = find(list);
            if (max == -1) {
                return -1;
            }
            answer += max;
        }

        return answer;


    }

    static void make() {
        parent = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            parent[i] = i;
        }
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
            return true;
        }

        return false;
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static int find(List<Integer> list) {
        int max = 0;
        
        for (int start : list) {
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> depth = new HashMap<>();
            queue.add(start);
            depth.put(start, 1);

            int localMax = 1;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int curDepth = depth.get(cur);

                for (int adj : listArr[cur]) {
                    if (!depth.containsKey(adj)) {
                        depth.put(adj, curDepth + 1);
                        queue.offer(adj);
                        localMax = Math.max(localMax, curDepth + 1);
                    } else if (Math.abs(depth.get(adj) - curDepth) != 1) {
                        return -1;
                    }
                }
            }

            max = Math.max(max, localMax);
        }

        return max;
    }
}