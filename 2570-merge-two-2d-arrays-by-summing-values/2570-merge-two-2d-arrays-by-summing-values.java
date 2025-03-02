class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<Integer> set = new HashSet<>();
        for (int[] nums : nums1) {
            set.add(nums[0]);
            pq.add(nums);
        }
        for (int[] nums : nums2) {
            set.add(nums[0]);
            pq.add(nums);
        }

        int len = set.size();
        int[][] answer = new int[len][2];
        answer[0] = pq.poll();

        int idx = 0;
        while (!pq.isEmpty()) {
            int[] nums = pq.poll();

            if (nums[0] == answer[idx][0]) {
                answer[idx][1] += nums[1];
            } else {
                idx++;
                if (idx >= len) {
                    break;
                }
                answer[idx][0] = nums[0];
                answer[idx][1] = nums[1];
            }
        }

        return answer;
    }
}
