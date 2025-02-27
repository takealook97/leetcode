class Solution {
    static int len, answer;
    static int[] arr;

    public int lenLongestFibSubseq(int[] arr) {
        len = arr.length;
        this.arr = arr;
        answer = 0;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                find (arr[i], arr[j], 0);
            }
        }

        return answer == 0 ? 0 : answer + 2;
    }

    static void find(int prev, int cur, int count) {
        answer = Math.max(answer, count);
        if (lowerBound(prev + cur)) {
            find(cur, prev + cur, count + 1);
        }
    }

    static boolean lowerBound(int target) {
        int lo = 0, hi = len - 1, mid;
        
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo < len && arr[lo] == target;
    }
}
