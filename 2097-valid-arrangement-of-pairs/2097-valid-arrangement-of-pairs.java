class Solution {
    static Map<Integer, List<Integer>> graph;
    static List<int[]> result;

    public int[][] validArrangement(int[][] pairs) {
        graph = new HashMap<>();
        result = new ArrayList<>();

        for (int[] pair : pairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
        }

        int start = findStartNode(pairs);

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                stack.push(graph.get(node).remove(0));
            } else {
                int to = stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[] {stack.peek(), to});
                }
            }
        }

        int size = result.size();
        int[][] answer = new int[size][2];
        for (int i = 0; i < size; i++) {
            answer[i] = result.get(result.size() - i - 1);
        }

        return answer;
    }

    private int findStartNode(int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + 1);
            map.put(pair[1], map.getOrDefault(pair[1], 0) - 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }
        return pairs[0][0];
    }
}
