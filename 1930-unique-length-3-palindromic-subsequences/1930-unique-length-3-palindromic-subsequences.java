class Solution {
    static Map<Character, Integer> lenMap;
    static Map<Character, int[]> idxMap;
    static int answer;

    static final int SIZE = 26;

    public int countPalindromicSubsequence(String s) {
        int len = s.length();
        lenMap = new HashMap<>();
        idxMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            lenMap.put(c, lenMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < SIZE; i++) {
            char c = (char) ('a' + i);
            if (lenMap.containsKey(c)) {
                idxMap.put(c, new int[lenMap.get(c)]);
            }
        }

        int[] idxArr = new int[SIZE];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            int[] arr = idxMap.get(c);
            arr[idxArr[idx]++] = i;
        }

        answer = 0;

        for (char key : idxMap.keySet()) {
            int[] val = idxMap.get(key);
            int from = val[0];
            int to = val[val.length - 1];
            if (to - from <= 1) {
                continue;
            }

            for (char c : idxMap.keySet()) {
                int[] arr = idxMap.get(c);
                // from 보다 크면서, to 보다 작은 인덱스가 arr에 있는지 판별
                int result = upperBound(arr, from);
                if (result < arr.length && from < arr[result] && arr[result] < to) {
                    answer++;
                }
            }
        }

        return answer;
    }

    static int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
