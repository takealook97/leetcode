class Solution {
    static int len, answer;
    static int[] nums;
    static boolean[] visited;

    public int subsetXORSum(int[] nums) {
        len = nums.length;
        if (len == 0) {
            return 0;
        }

        answer = 0;
        this.nums = nums;
        visited = new boolean[len];

        find(0);

        return answer;
    }

    static void find(int idx) {
        if (idx >= len) {
            update();
            return;
        }
        
        find(idx + 1);
        visited[idx] = true;
        find(idx + 1);
        visited[idx] = false;

    }

    static void update() {
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                result ^= nums[i];
            }
        }

        answer += result;
    }
}
