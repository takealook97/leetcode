class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        char prev = 0;
        String now;
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (prev != cur) {
                prev = cur;
                sb = new StringBuilder();
                sb.append(cur);
                now = sb.toString();
                map.put(now, map.getOrDefault(now, 0) + 1);
            } else {
                sb.append(cur);
                now = sb.toString();
                int strLen = now.length();
                for (int j = 1; j <= strLen; j++) {
                    String subStr = now.substring(0, j);
                    map.put(subStr, map.getOrDefault(subStr, 0) + 1);
                }
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> Integer.compare(b.length(), a.length()));

        for (String key : list) {
            int val = map.get(key);
            if (val >= 3) {
                return key.length();
            }
        }

        return -1;
    }
}
