class Solution {
    public int minOperations(int[] nums) {
        int len = nums.length;
        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && i > deque.peek() + 2) {
                deque.poll();
            }

            if ((nums[i] + deque.size()) % 2 == 0) {
                if (i + 2 >= len) {
                    return -1;
                }
                count++;
                deque.add(i);
            }
        }
        
        return count;
    }
}
