class Solution {
    static int len, answer;
    static int[] bits;

    static final int LIMIT = 32;
    
    public static int minimumSubarrayLength(int[] nums, int k) {
        len = nums.length;
        answer = Integer.MAX_VALUE;
        bits = new int[LIMIT];
        
        for (int lo = 0, hi = 0; hi < len; hi++) {
            add(nums[hi]);
            while (lo <= hi && getValue() >= k) {
                answer = Math.min(hi - lo + 1, answer);
                remove(nums[lo]);
                lo++;
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    static void add(int num) {
        for (int i = 0; i < LIMIT; i++) {
            bits[i] += (num & 1);
            num >>= 1;
        }
    }

    static void remove(int num) {
        for (int i = 0; i < LIMIT; i++) {
            bits[i] -= (num & 1);
            num >>= 1;
        }
    }

    static int getValue() {
        int val = 0;
        for (int i = 0; i < LIMIT; i++) {
            if (bits[i] > 0) {
                val |= (1 << i);
            }
        }
        return val;
    }
}
