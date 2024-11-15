class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int lo = 0, hi = len - 1;

        while (lo + 1 < len && arr[lo] <= arr[lo + 1]) {
            lo++;
        }
        if (lo == len - 1) {
            return 0;
        }

        while (hi > 0 && arr[hi - 1] <= arr[hi]) {
            hi--;
        }

        int answer = Math.min(len - lo - 1, hi);
        for (int i = 0; i <= lo && hi < len; i++) {
            if (arr[i] <= arr[hi]) {
                answer = Math.min(answer, hi - i - 1);
            } else {
                hi++;
            }
        }

        return answer;
    }
}
