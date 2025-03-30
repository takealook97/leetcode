class Solution {
    static int len;
    static String s;
    static boolean[] visited;
    static Map<Character, List<Integer>> map;

    public List<Integer> partitionLabels(String s) {
        len = s.length();
        this.s = s;
        visited = new boolean[26];
        map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }

        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        while(idx < len - 1) {
            int temp = idx;
            idx = getLastIdx(idx, s.charAt(idx));
            idx++;
            answer.add(idx - temp);
        }

        return answer;
    }

    static int getLastIdx(int start, char now) {
        List<Integer> list = map.get(now);
        int end = list.get(list.size() - 1);
        int lastIdx = end;
        visited[now - 'a'] = true;

        for (int i = start; i <= end; i++) {
            char next = s.charAt(i);
            if (!visited[next - 'a']) {
                lastIdx = Math.max(lastIdx, getLastIdx(start, next));
            }
        }

        return lastIdx;
    }
}
