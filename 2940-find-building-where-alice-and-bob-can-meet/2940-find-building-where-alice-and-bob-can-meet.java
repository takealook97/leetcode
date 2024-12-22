import java.util.*;

class Solution {

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<int[]> monoStack = new ArrayList<>();
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        List<List<int[]>> newQueries = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            newQueries.add(new ArrayList<>());
        }

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (heights[b] > heights[a] || a == b) {
                result[i] = b;
            } else {
                newQueries.get(b).add(new int[] { heights[a], i });
            }
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            int monoStackSize = monoStack.size();
            for (int[] query : newQueries.get(i)) {
                int position = search(query[0], monoStack);
                if (position < monoStackSize && position >= 0) {
                    result[query[1]] = monoStack.get(position)[1];
                }
            }

            while (
                !monoStack.isEmpty() &&
                monoStack.get(monoStack.size() - 1)[0] <= heights[i]
            ) {
                monoStack.remove(monoStack.size() - 1);
            }

            monoStack.add(new int[] { heights[i], i });
        }

        return result;
    }

    static int search(int height, List<int[]> monoStack) {
        int left = 0;
        int right = monoStack.size() - 1;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (monoStack.get(mid)[0] > height) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
