class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = 0, answer = 0;

        while (true) {
            if (empty < numExchange) {
                if (numBottles < numExchange) {
                    if (numBottles > 0) {
                        empty += numBottles;
                        answer += numBottles;
                        numBottles = 0;
                        continue;
                    } else {
                        break;
                    }
                }

                empty += numBottles;
                answer += numBottles;
                numBottles = 0;
            } else {
                empty -= numExchange;
                numBottles++;
                numExchange++;
            }
        }

        return answer;
    }
}
