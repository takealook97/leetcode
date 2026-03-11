class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder sb = new StringBuilder();
        String bit = Integer.toBinaryString(n);
        for (char c : bit.toCharArray()) {
            if (c == '0') {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}
