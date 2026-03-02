class Solution {
    public int minSwaps(int[][] grid) {
        int len = grid.length;
        int[] arr = new int[len];

        for (int y = 0; y < len; y++) {
            int cur = 0;
            for (int x = len - 1; x >= 0; x--) {
                if (grid[y][x] == 0) {
                    cur++;
                } else {
                    break;
                }
            }
            arr[y] = cur;
        }

        int answer = 0;
        for (int i = 0; i < len; i++) {
            int required = len - 1 - i;
            int j = i;

            while (j < len && arr[j] < required) {
                j++;
            }

            if (j == len) {
                return -1;
            }

            while (j > i) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
                answer++;
            }
        }

        return answer;
    }
}