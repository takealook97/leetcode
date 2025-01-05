class Solution {
    static final int START = 0, END = 1, DIR = 2, FORWARD = 1, BACKWARD = 2, SIZE = 26;

    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length();
        int[] diff = new int[len + 1];

        for (int[] shift : shifts) {
            diff[shift[START]] += (shift[DIR] == FORWARD) ? 1 : -1;
            if (shift[END] + 1 < len) {
                diff[shift[END] + 1] -= (shift[DIR] == FORWARD) ? 1 : -1;
            }
        }

        int[] moveArr = new int[len];
        int shiftAmount = 0;
        for (int i = 0; i < len; i++) {
            shiftAmount += diff[i];
            moveArr[i] = shiftAmount;
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i++) {
            arr[i] += (moveArr[i] % SIZE);
            if (arr[i] < 'a') {
                arr[i] += SIZE;
            } else if (arr[i] > 'z') {
                arr[i] -= SIZE;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        return sb.toString();
    }
}
