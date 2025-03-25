class Solution {
    static int len;
    static int[][] arrX, arrY;
    static final int FROM = 0, TO = 1, FROM_X = 0, FROM_Y = 1, TO_X = 2, TO_Y = 3;

    public boolean checkValidCuts(int n, int[][] rectangles) {
        make(n, rectangles);

        return check(arrX) || check(arrY);
    }

    static void make(int n, int[][] rectangles) {
        len = rectangles.length;
        arrX = new int[len][2];
        arrY = new int[len][2];
        for (int i = 0; i < len; i++) {
            arrX[i][FROM] = rectangles[i][FROM_X];
            arrX[i][TO] = rectangles[i][TO_X];
            arrY[i][FROM] = rectangles[i][FROM_Y];
            arrY[i][TO] = rectangles[i][TO_Y];
        }

        Arrays.sort(arrX, (o1, o2) -> {
            return o1[FROM] == o2[FROM] ? o2[TO] - o1[TO] : o1[FROM] - o2[FROM];
        });

        Arrays.sort(arrY, (o1, o2) -> {
            return o1[FROM] == o2[FROM] ? o2[TO] - o1[TO] : o1[FROM] - o2[FROM];
        });
    }

    static boolean check(int[][] arr) {
        int lo = arr[0][FROM], hi = arr[0][TO];
        int count = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i][FROM] == lo || arr[i][TO] <= hi) {
                continue;
            }

            if (hi <= arr[i][FROM]) {
                count++;
            }
            lo = arr[i][FROM];
            hi = arr[i][TO];
        }

        return count >= 2;
    }
}
