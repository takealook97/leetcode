/**
1
11
21
1211
111221
312211
13112221
1113213211

 */

class Solution {
    public String countAndSay(int n) {
        String s = "1";
        while (n-- > 1) {
            s = find(s);
        }

        return s;
    }

    static String find(String num) {
        StringBuilder sb = new StringBuilder();
        int len = num.length(), cur = num.charAt(0) - '0', count = 0, p = 0;
        for (int i = 0; i < len; i++) {
            p = num.charAt(i) - '0';
            if (cur == p) {
                count++;
            } else {
                sb.append(count).append(cur);
                cur = p;
                count = 1;
            }
        }
        sb.append(count).append(p);

        return sb.toString();
    }
}
