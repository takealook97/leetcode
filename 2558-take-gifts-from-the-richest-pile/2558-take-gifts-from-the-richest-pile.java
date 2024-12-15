class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            pq.add(gift);
        }

        while (k-- > 0) {
            pq.add((int) Math.floor(Math.sqrt(pq.poll())));
        }
        

        long answer = 0;
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }

        return answer;
    }
}
