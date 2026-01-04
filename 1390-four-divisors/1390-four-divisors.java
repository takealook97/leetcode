class Solution {
    public int sumFourDivisors(int[] nums) {
        int answer = 0, count, sum;

        for (int num : nums) {
            count = 0;
            sum = 1 + num;

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    int x = num / i;
                    count++;
                    sum += i;

                    if (x != i) {
                        count++;
                        sum += x;
                    }

                    if (count > 2) {
                        break;
                    }
                }
            }

            if (count == 2) {
                answer += sum;
            }
        }

        return answer;
    }
}
