class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        sb.append(n / d);
        long remainder = n % d;
        if (remainder == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / d);
            remainder %= d;
        }
        return sb.toString();
    }
}