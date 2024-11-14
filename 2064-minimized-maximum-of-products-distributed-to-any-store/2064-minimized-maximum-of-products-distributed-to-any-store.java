class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        Arrays.sort(quantities);
        int lo = 1;
        int hi = 0;
        
        for (int quantity : quantities) {
            hi = Math.max(hi, quantity);
        }
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(n, quantities, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
    
    private boolean isPossible(int n, int[] quantities, int d) {
        int count = 0;
        for (int quantity : quantities) {
            count += (quantity + d - 1) / d;
            if (count > n) {
                return false;
            }
        }
        
        return count <= n;
    }
}
