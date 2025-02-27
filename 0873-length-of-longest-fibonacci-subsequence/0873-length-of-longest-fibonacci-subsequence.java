class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int x = arr[i], y = arr[j];
                int count = 2;
                
                while (map.containsKey(x + y)) {
                    int next = x + y;
                    x = y;
                    y = next;
                    count++;

                    answer = Math.max(answer, count);
                }
            }
        }

        return answer >= 3 ? answer : 0;
    }
}
