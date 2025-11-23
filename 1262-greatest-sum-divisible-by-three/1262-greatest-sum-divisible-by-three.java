class Solution {
    static int IMPOSSIBLE = -1;

    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        int a = IMPOSSIBLE;
        int b = IMPOSSIBLE;
        int c = IMPOSSIBLE;
        int d = IMPOSSIBLE;        
        for (int num : nums) {
            sum += num;

            if (num % 3 == 1) {
                if (a == IMPOSSIBLE) {
                    a = num;
                } else if (b == IMPOSSIBLE) {
                    b = num;
                }
            } else if (num % 3 == 2) {
                if (c == IMPOSSIBLE) {
                    c = num;
                } else if (d == IMPOSSIBLE) {
                    d = num;
                }
            }
        }

        int mod = sum % 3;
        if (mod == 0) {
            return sum;
        }

        // 1 vs 22
        // 2 vs 11
        if (mod == 1) {
            if (a != IMPOSSIBLE) {
                if (c != IMPOSSIBLE && d != IMPOSSIBLE) {
                    int min = Math.min(a, c + d);
                    return sum - min;
                }
                return sum - a;
            } else if (c != IMPOSSIBLE && d != IMPOSSIBLE) {
                return sum - (c + d);
            } else {
                return 0;
            }
        } else { // mod == 2
            if (c != IMPOSSIBLE) {
                if (a != IMPOSSIBLE && b != IMPOSSIBLE) {
                    int min = Math.min(c, a + b);
                    return sum - min;
                }
                return sum - c;
            } else if (a != IMPOSSIBLE && b != IMPOSSIBLE) {
                return sum - (a + b);
            } else {
                return 0;
            }
        }
    }
}
