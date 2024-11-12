import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int[] maxBeautyByPrice = new int[items.length];
        
        maxBeautyByPrice[0] = items[0][1];
        for (int i = 1; i < items.length; i++) {
            maxBeautyByPrice[i] = Math.max(maxBeautyByPrice[i - 1], items[i][1]);
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int idx = binarySearch(items, query);
            answer[i] = idx == -1 ? 0 : maxBeautyByPrice[idx];
        }

        return answer;
    }

    private int binarySearch(int[][] items, int target) {
        int left = 0, right = items.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (items[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
