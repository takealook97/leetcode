class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int j = y; j < y + k; j++) {
            for (int i = x; i < x + k; i++) {
                stack.add(grid[i][j]);
            }

            for (int i = x; i < x + k; i++) {
                grid[i][j] = stack.pop();
            }
        }

        return grid;
    }
}
