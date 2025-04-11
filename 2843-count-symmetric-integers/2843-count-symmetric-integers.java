class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int answer = 0;
        for (int i = low; i <= high; i++) {
            if (isPossible(i)) {
                answer++;
            }
        }

        return answer;
    }

    static boolean isPossible(int num) {
        if (num < 10 || (100 <= num && num < 1000) || num >= 10000) {
            return false;
        }

        String numString = Integer.toString(num);
        int len = numString.length();
        int left = 0, right = 0;
        for (int i = 0; i < len / 2; i++) {
            left += numString.charAt(i) - '0';
        }

        for (int i = len / 2; i < len; i++) {
            right += numString.charAt(i) - '0';
        }

        return left == right;
    }
}
