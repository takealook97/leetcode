class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int len = queries.length;
        HashMap<Integer, Integer> colors = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[len];
        
        int idx = 0;
        for (int[] query : queries) {
            int target = query[0];
            int color = query[1];

            if (colors.containsKey(target)) {
                int prevColor = colors.get(target);
                if (map.get(prevColor) == 1) {
                    map.remove(prevColor);
                } else {
                    map.put(prevColor, map.get(prevColor) - 1);
                }
            }

            colors.put(target, color);
            map.put(color, map.getOrDefault(color, 0) + 1);
            answer[idx++] = map.size();
        }

        return answer;
    }
}
