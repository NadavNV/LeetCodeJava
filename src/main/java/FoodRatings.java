import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Food implements Comparable<Food> {
    public int rating;
    public String name;

    public Food(int rating, String name) {
        this.rating = rating;
        this.name = name;
    }


    @Override
    public int compareTo(Food other) {
        if (this.rating == other.rating) {
            return this.name.compareTo(other.name);
        }
        // Higher ratings should go to the top of the minHeap
        return -1 * Integer.compare(this.rating, other.rating);
    }
}


class FoodRatings {
    private final Map<String, Integer> foodToRatings;
    private final Map<String, String> foodToCuisine;
    private final Map<String, PriorityQueue<Food>> cuisineToFood;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRatings = new HashMap<>();
        cuisineToFood = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToRatings.put(foods[i], ratings[i]);
            foodToCuisine.put(foods[i], cuisines[i]);
            cuisineToFood.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>())
                    .add(new Food(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodToRatings.put(food, newRating);
        String cuisineName = foodToCuisine.get(food);
        cuisineToFood.get(cuisineName).add(new Food(newRating, food));
    }

    public String highestRated(String cuisine) {
        Food highest = cuisineToFood.get(cuisine).peek();

        while (highest.rating != foodToRatings.get(highest.name)) {
            cuisineToFood.get(cuisine).poll();
            highest = cuisineToFood.get(cuisine).peek();
        }

        return highest.name;
    }
}