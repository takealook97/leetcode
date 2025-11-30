import java.util.*;

class Solution {
    static int len, p;
    static long mod;
    static long[] sumArr;

    public int minSubarray(int[] nums, int p) {
        len = nums.length;
        this.p = p;

        sumArr = new long[len];
        sumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sumArr[i] = sumArr[i - 1] + nums[i];
        }

        mod = sumArr[len - 1] % p;
        if (mod == 0) {
            return 0;
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        int answer = len;
        long now;

        for (int i = 0; i < len; i++) {
            now = sumArr[i] % p;

            long target = (now - mod + p) % p;
            if (map.containsKey(target)) {
                answer = Math.min(answer, i - map.get(target));
            }

            map.put(now, i);
        }

        return answer == len ? -1 : answer;
    }
}
