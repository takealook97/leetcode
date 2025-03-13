class Solution {
    static int n, q;
    static int[] nums;
    static int[][] queries;

    public int minZeroArray(int[] nums, int[][] queries) {
        this.nums = nums;
        this.queries = queries;
        n = nums.length;
        q = queries.length;
        
        int lo = 0, hi = q, answer = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(mid)) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return answer;
    }

    static boolean check(int k) {
        int[] temp = nums.clone();
        int[] diff = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            
            diff[l] -= val;
            if (r + 1 < n) {
                diff[r + 1] += val;
            }
        }

        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            temp[i] += cur;
            if (temp[i] > 0) {
                return false;
            }
        }

        return true;
    }
} 
