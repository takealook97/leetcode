class FoodRatings {
    static int len;
    static String[] foods, cuisines;
    static int[] ratings;
    static Map<String, PriorityQueue<Food>> mapA, mapB;
    static Map<String, String> foodToCuisine;
    static List<Food> temp;

    static class Food implements Comparable<Food> {
        int idx, rating;

        public Food(int idx, int rating) {
            this.idx = idx;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food o) {
            if (o.rating != this.rating) {
                return o.rating - this.rating;
            }
            return foods[this.idx].compareTo(foods[o.idx]);
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        len = foods.length;
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        setMap();
        temp = new ArrayList<>();
    }

    static void setMap() {
        mapA = new HashMap<>();
        mapB = new HashMap<>();
        foodToCuisine = new HashMap<>();
        for (int idx = 0; idx < len; idx++) {
            mapA.computeIfAbsent(foods[idx], k -> new PriorityQueue<>());
            mapB.computeIfAbsent(cuisines[idx], k -> new PriorityQueue<>());
            mapA.get(foods[idx]).add(new Food(idx, ratings[idx]));
            mapB.get(cuisines[idx]).add(new Food(idx, ratings[idx]));
            foodToCuisine.put(foods[idx], cuisines[idx]);
        }
    }

    public void changeRating(String food, int newRating) {
        PriorityQueue<Food> pq = mapA.get(food);
        while (!pq.isEmpty()) {
            Food f = pq.poll();
            f.rating = newRating;
            ratings[f.idx] = newRating;
            temp.add(f);
        }
        pq.addAll(temp);
        temp.clear();

        String cuisine = foodToCuisine.get(food);
        pq = mapB.get(cuisine);
        while (!pq.isEmpty()) {
            Food f = pq.poll();
            if (foods[f.idx].equals(food)) {
                f.rating = newRating;
                ratings[f.idx] = newRating;
            }
            temp.add(f);
        }
        pq.addAll(temp);
        temp.clear();
    }

    public String highestRated(String cuisine) {
        int idx = mapB.get(cuisine).peek().idx;
        return foods[idx];
    }
}
