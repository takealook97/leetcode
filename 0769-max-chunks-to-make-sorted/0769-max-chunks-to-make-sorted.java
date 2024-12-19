class Solution {
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int[] maxArr = Arrays.copyOf(arr, len);
        int[] minArr = Arrays.copyOf(arr, len);

        for (int i = 1; i < len; i++) {
            maxArr[i] = Math.max(maxArr[i - 1], maxArr[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            minArr[i] = Math.min(minArr[i + 1], minArr[i]);
        }

        int answer = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0 || minArr[i] > maxArr[i - 1]) {
                answer++;
            }
        }

        return answer;
    }
}
