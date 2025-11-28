class Solution {
    public int maxOperations(String s) {
        int len = s.length(), count = 0, answer = 0;
        boolean check = false;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                count++;
                check = true;
            } else {
                if (check) {
                    answer += count;
                }

                check = false;
            }
        }

        return answer;
    }
}
