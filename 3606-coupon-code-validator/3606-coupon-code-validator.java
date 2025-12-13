class Solution {
    static final String REGEX = "^[a-zA-Z0-9_]+$";

    static class Coupon implements Comparable<Coupon> {
        String code;
        String businessLine;
        boolean isActive;

        public Coupon(String code, String businessLine, boolean isActive) {
            this.code = code;
            this.businessLine = businessLine;
            this.isActive = isActive;
        }

        static int getOrder(String s) {
            if (s.equals("electronics")) return 0;
            if (s.equals("grocery")) return 1;
            if (s.equals("pharmacy")) return 2;
            return 3;
        }

        @Override
        public int compareTo(Coupon o) {
            int a = getOrder(this.businessLine);
            int b = getOrder(o.businessLine);
            if (a != b) return a - b;
            return this.code.compareTo(o.code);
        }
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int len = code.length;
        Set<String> set = new HashSet<>(Arrays.asList(
            "electronics", "grocery", "pharmacy", "restaurant"
        ));

        List<Coupon> list = new ArrayList<>();

        for (int idx = 0; idx < len; idx++) {
            if (code[idx].matches(REGEX) && set.contains(businessLine[idx]) && isActive[idx]) {
                list.add(new Coupon(code[idx], businessLine[idx], isActive[idx]));
            }
        }

        Collections.sort(list);

        List<String> answer = new ArrayList<>();
        for (Coupon c : list) {
            answer.add(c.code);
        }

        return answer;
    }
}
