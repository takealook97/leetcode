class Solution {
    public int punishmentNumber(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (find(String.valueOf(i * i), 0, i, 0)) {
                answer += (i * i);
            }
        }
        return answer;
    }

    static boolean find(String s, int idx, int target, int cur) {
        if (idx == s.length()) {
            return cur == target;
        }

        int num = 0;
        for (int i = idx; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (find(s, i + 1, target, cur + num)) {
                return true;
            }
        }
        return false;
    }
}
