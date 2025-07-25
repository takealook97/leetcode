class Solution {
	public static int maxSum(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int num : nums) {
			max = Math.max(num, max);
			if (num >= 0) {
				if (set.add(num)) {
					sum += num;
				}
			}
		}
		if (set.isEmpty()) {
			return max;
		}
		return sum;
	}
}