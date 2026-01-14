class Solution {
    static class Event {
        double y, x1, x2;
        int type;

        Event(double y, double x1, double x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;
        Event[] events = new Event[n * 2];
        int idx = 0;

        for (int[] s : squares) {
            double x1 = s[0];
            double x2 = x1 + s[2];
            double y1 = s[1];
            double y2 = y1 + s[2];

            events[idx++] = new Event(y1, x1, x2, 1);
            events[idx++] = new Event(y2, x1, x2, -1);
        }

        Arrays.sort(events, 0, idx, (a, b) -> Double.compare(a.y, b.y));

        ArrayList<double[]> active = new ArrayList<>();
        double total = 0.0;
        double prevY = events[0].y;

        for (int i = 0; i < idx; i++) {
            double curY = events[i].y;
            double h = curY - prevY;
            if (h > 0 && !active.isEmpty()) {
                total += mergeWidth(active) * h;
            }

            if (events[i].type == 1) {
                active.add(new double[]{events[i].x1, events[i].x2});
            } else {
                for (int k = 0; k < active.size(); k++) {
                    if (active.get(k)[0] == events[i].x1 &&
                        active.get(k)[1] == events[i].x2) {
                        active.remove(k);
                        break;
                    }
                }
            }

            prevY = curY;
        }

        double half = total / 2.0;
        active.clear();
        prevY = events[0].y;
        double acc = 0.0;

        for (int i = 0; i < idx; i++) {
            double curY = events[i].y;
            double h = curY - prevY;

            if (h > 0 && !active.isEmpty()) {
                double w = mergeWidth(active);
                double area = w * h;
                if (acc + area >= half) {
                    return prevY + (half - acc) / w;
                }
                acc += area;
            }

            if (events[i].type == 1) {
                active.add(new double[]{events[i].x1, events[i].x2});
            } else {
                for (int k = 0; k < active.size(); k++) {
                    if (active.get(k)[0] == events[i].x1 &&
                        active.get(k)[1] == events[i].x2) {
                        active.remove(k);
                        break;
                    }
                }
            }

            prevY = curY;
        }

        return prevY;
    }

    static double mergeWidth(ArrayList<double[]> list) {
        list.sort((a, b) -> Double.compare(a[0], b[0]));

        double w = 0.0;
        double l = list.get(0)[0];
        double r = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            double nl = list.get(i)[0];
            double nr = list.get(i)[1];
            if (nl > r) {
                w += r - l;
                l = nl;
                r = nr;
            } else {
                r = Math.max(r, nr);
            }
        }

        return w + (r - l);
    }
}
