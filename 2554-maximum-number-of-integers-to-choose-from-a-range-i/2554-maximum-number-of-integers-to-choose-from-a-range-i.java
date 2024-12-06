class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] removed = new boolean[n + 1];
        int removeCnt = 0;
        for (int num : banned) {
            if (num <= n && !removed[num]) {
                removed[num] = true;
                removeCnt++;
            }
        }

        int[] arr = new int[n - removeCnt];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (!removed[i]) {
                arr[idx++] = i;
            }
        }

        int sum = 0;
        int answer = 0;
        for (int num : arr) {
            if (sum + num <= maxSum) {
                sum += num;
                answer++;
            }
        }

        return answer;
    }
}
