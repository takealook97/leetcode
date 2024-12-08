import java.util.*;

class Solution {
    static class Period {
        int start, end, val;

        public Period(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }

    public int maxTwoEvents(int[][] events) {
        List<Period> list = new ArrayList<>();
        for (int[] event : events) {
            list.add(new Period(event[0], event[1], event[2]));
        }

        list.sort((a, b) -> a.end == b.end ? a.start - b.start : a.end - b.end);

        int[] arr = new int[list.size()];
        arr[0] = list.get(0).val;
        for (int i = 1; i < list.size(); i++) {
            arr[i] = Math.max(arr[i - 1], list.get(i).val);
        }

        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            answer = Math.max(answer, list.get(i).val);
            int lo = -1, hi = i - 1;
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;
                if (list.get(mid).end < list.get(i).start) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }

            if (lo != -1) {
                answer = Math.max(answer, list.get(i).val + arr[lo]);
            }
        }

        return answer;
    }
}
