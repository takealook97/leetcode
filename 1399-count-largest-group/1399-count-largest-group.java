class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int num = i, sum = 0;
            while (num > 0) {
                sum += (num % 10);
                num /= 10;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        int maxSize = 0, answer = 0;
        for (int count : map.values()) {
            if (maxSize < count) {
                maxSize = count;
                answer = 1;
            } else if (maxSize == count) {
                answer++;
            }
        }

        return answer;
    }
}
