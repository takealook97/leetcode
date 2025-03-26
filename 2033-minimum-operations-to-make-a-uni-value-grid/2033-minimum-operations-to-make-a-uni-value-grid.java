class Solution {
    static int n, m, x, len;
    static int[] arr;

    public int minOperations(int[][] grid, int x) {
        n = grid.length;
        m = grid[0].length;
        this.x = x;
        len = n * m;
        arr = new int[len];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        Arrays.sort(arr);
        
        int answer = Integer.MAX_VALUE;
        int lo = 0, hi = len - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int result = getResult(arr[mid]);
            if (result != -1) {
                answer = Math.min(answer, result);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    static int getResult(int target) {
        int count = 0;
        for (int num : arr) {
            int gap = Math.abs(target - num);
            if (gap % x != 0) {
                return -1;
            }

            count += (gap / x);
        }

        return count;
    }
}