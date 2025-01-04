class Solution {
    public int countPalindromicSubsequence(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<>();
        Set<Character> temp = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        int answer = 0;

        for (Character c : set) {
            int x = -1;
            int y = 0;
            for (int i = 0; i < len; i++) {
                if (c == s.charAt(i)) {
                    if (x == -1) {
                        x = i;
                    }
                    y = i;
                }
            }

            for (int i = x + 1; i < y; i++) {
                temp.add(s.charAt(i));
            }
            answer += temp.size();
            temp.clear();
        }

        return answer;
    }
}
