class Solution {
    public int countCollisions(String s) {
        int len = s.length();
        int i = 0, j = len - 1;

        while (i < len && s.charAt(i) == 'L') i++;
        while (j >= 0 && s.charAt(j) == 'R') j--;

        int answer = 0;

        for (int k = i; k <= j; k++) {
            char c = s.charAt(k);
            if (c == 'R' || c == 'L') answer++;
        }

        return answer;
    }
}
