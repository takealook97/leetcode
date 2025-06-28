class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);
        Arrays.sort(arr);

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = n - k; i < n; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }

        int[] answer = new int[k];
        int idx = 0;
        for (int num : nums) {
            if (countMap.getOrDefault(num, 0) > 0) {
                answer[idx++] = num;
                countMap.put(num, countMap.get(num) - 1);
                if (idx == k) break;
            }
        }

        return answer;
    }
}
