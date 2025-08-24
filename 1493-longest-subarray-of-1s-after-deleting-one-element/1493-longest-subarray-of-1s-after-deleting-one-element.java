class Solution {
    public int longestSubarray(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }

        int count = 1;
        int lo = 0, hi = 1;
        while (hi < len) {
            if (nums[lo] == nums[hi]) {
                count++;
            } else {
                if (nums[lo] == 0) {
                    list.add(-count);
                } else {
                    list.add(count);
                }
                lo = hi;
                hi++;
                if (hi >= len) break;
                count = 1;
                continue;
            }
            hi++;
        }

        if (nums[lo] == 0) {
            list.add(-count);
        } else {
            list.add(count);
        }

        int size = list.size();
        int answer = 0;
        if (size == 1) {
            if (nums[0] == 1) {
                return list.get(0) - 1;
            } else {
                return 0;
            }
        }
        
        for (int i = 0; i < size; i++) {
            int prev = i > 0 ? list.get(i - 1) : 0;
            int now = list.get(i);
            int next = i < size - 1 ? list.get(i + 1) : 0;

            answer = Math.max(answer, now);
            if (now == -1 && prev > 0 && next > 0) {
                answer = Math.max(answer, prev + next);
            }
        }

        return answer;
    }
}