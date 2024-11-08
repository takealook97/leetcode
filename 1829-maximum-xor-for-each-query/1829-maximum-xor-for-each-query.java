class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int len = nums.length;
        int[] answer = new int[len];
        
        int mask = (1 << maximumBit) - 1;
        
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        for (int i = 0; i < len; i++) {
            answer[i] = xor ^ mask;
            xor ^= nums[len - 1 - i];
        }
        
        return answer;
    }
}
