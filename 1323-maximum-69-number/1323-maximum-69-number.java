class Solution {
    public int maximum69Number (int num) {
        String numStr = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        int len = numStr.length();
        boolean check = false;
        for (int i = 0; i < len; i++) {
            char c = numStr.charAt(i);
            if (!check && c == '6') {
                sb.append(9);
                check = true;
            } else {
                sb.append(c);
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
