class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int len = buildings.length;
        Map<String, Integer> map = new HashMap<>();

        Arrays.sort(buildings, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int curX = -1, x, y;
        String prev = null, cur;
        for (int i = 0; i < len; i++) {
            x = buildings[i][0];
            y = buildings[i][1];
            cur = x + "," + y;

            if (curX != x) {
                map.remove(prev);
                curX = x;
            } else {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }

            prev = cur;
        }
        map.remove(prev);

        Arrays.sort(buildings, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int curY = -1;
        prev = null;
        for (int i = 0; i < len; i++) {
            x = buildings[i][0];
            y = buildings[i][1];
            cur = x + "," + y;

            if (curY != y) {
                map.remove(prev);
                curY = y;
            } else {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }

            prev = cur;
        }
        map.remove(prev);

        int answer = 0;
        for (int val : map.values()) {
            if (val == 2) {
                answer++;
            }
        }

        return answer;
    }
}