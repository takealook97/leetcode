import java.util.*;

class Solution {
    static int N, target, answer;
    static int[] nums;

    public int countMaxOrSubsets(int[] nums) {
        N = nums.length;
        this.nums = nums;
        target = 0;
        for(int num : nums) {
            target |= num;
        }
        answer = 0;

        find(0, 0);

        return answer;
    }

    static void find(int now, int idx) {
        if (idx >= N) {
            if (now == target) {
                answer++;
            }
            return;
        }

        find(now | nums[idx], idx + 1);
        find(now, idx + 1);
    }
}

