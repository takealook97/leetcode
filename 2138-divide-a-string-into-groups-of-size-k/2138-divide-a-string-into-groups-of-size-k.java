class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        String[] answer = new String[len / k + (len % k != 0 ? 1 : 0)];

        int idx = 0;
        for (int i = 0; i < len; i += k) {
            if (i + k <= len) {
                answer[idx++] = s.substring(i, i + k);
            } else {
                StringBuilder sb = new StringBuilder(s.substring(i, len));
                for (int j = 0; j < i + k - len; j++) {
                    sb.append(fill);
                }
                answer[idx] = sb.toString();
                break;
            }
        }

        return answer;
    }
}
