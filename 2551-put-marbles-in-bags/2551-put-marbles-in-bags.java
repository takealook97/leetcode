class Solution {
    public long putMarbles(int[] weights, int k) {
        int len = weights.length;
        int[] arr = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            arr[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(arr);

        long answer = 0;
        for (int i = 0; i < k - 1; i++) {
            answer += arr[len - 2 - i] - arr[i];
        }

        return answer;
    }
}
