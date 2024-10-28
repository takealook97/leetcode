class Solution {
    public int longestSquareStreak(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        boolean[] visited = new boolean[N];

        long cur, target;
        int count, targetIdx, answer = 0;
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                cur = nums[i];
                count = 1;
                targetIdx = -1;

                while (true) {
                    target = cur * cur;
                    targetIdx = lowerBound(nums, i, N - 1, target);
                    if (targetIdx < N && nums[targetIdx] == target && !visited[targetIdx]) {
                        count++;
                        cur = target;
                        visited[targetIdx] = true;
                        continue;
                    }

                    break;
                }

                answer = Math.max(answer, count);
            }
        }

        return answer == 1 ? -1 : answer;
    }

    static int lowerBound(int[] nums, int lo, int hi, long target) {
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
