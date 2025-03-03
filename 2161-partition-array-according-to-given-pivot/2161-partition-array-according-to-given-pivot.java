class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> lower = new ArrayDeque<>();
        Queue<Integer> upper = new ArrayDeque<>();
        int pivotCount = 0;

        for (int num : nums) {
            if (num < pivot) {
                lower.add(num);
            } else if (num > pivot) {
                upper.add(num);
            } else {
                pivotCount++;
            }
        }
        
        int len = nums.length;
        int[] answer = new int[len];
        int idx = 0;

        while (!lower.isEmpty()) {
            answer[idx++] = lower.poll();
        }

        while (pivotCount-- > 0) {
            answer[idx++] = pivot;
        }

        while (!upper.isEmpty()) {
            answer[idx++] = upper.poll();
        }
        
        return answer;
    }
}
