import java.util.*;

class Solution {
    static int N;
    static char temp;
    static char[] arr;

    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        arr = s.toCharArray();
        N = arr.length;
        int answer = num;

        for (int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                swap(i, j);
                answer = Math.max(answer, Integer.parseInt(String.valueOf(arr)));
                swap(j, i);
            }
        }

        return answer;
    }

    static void swap(int x, int y) {
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
