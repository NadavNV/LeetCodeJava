import java.util.*;

public class MovieRentingSystem {
    private record ShopEntry(int shop, int price) {
    }

    private record RentalEntry(int shop, int movie, int price) {
    }

    private final Comparator<ShopEntry> shopComparator =
            Comparator.comparingInt(ShopEntry::price)
                    .thenComparing(ShopEntry::shop);
    private final Comparator<RentalEntry> rentalComparator =
            Comparator.comparingInt(RentalEntry::price)
                    .thenComparingInt(RentalEntry::shop)
                    .thenComparingInt(RentalEntry::movie);

    private final Map<Integer, TreeSet<ShopEntry>> availableByMovie = new HashMap<>();
    private final TreeSet<RentalEntry> rented = new TreeSet<>(rentalComparator);
    private final Map<String, Integer> priceByShopAndMovie = new HashMap<>();

    private String key(int shop, int movie) {
        return shop + ":" + movie;
    }

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            availableByMovie
                    .computeIfAbsent(movie, k -> new TreeSet<>(shopComparator))
                    .add(new ShopEntry(shop, price));
            priceByShopAndMovie.put(key(shop, movie), price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!availableByMovie.containsKey(movie)) return result;
        for (ShopEntry e : availableByMovie.get(movie)) {
            result.add(e.shop);
            if (result.size() == 5) break;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = priceByShopAndMovie.get(key(shop, movie));
        availableByMovie.get(movie).remove(new ShopEntry(shop, price));
        rented.add(new RentalEntry(shop, movie, price));
    }

    public void drop(int shop, int movie) {
        int price = priceByShopAndMovie.get(key(shop, movie));
        rented.remove(new RentalEntry(shop, movie, price));
        availableByMovie.computeIfAbsent(movie, k -> new TreeSet<>(shopComparator))
                .add(new ShopEntry(shop, price));
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        for (RentalEntry entry : rented) {
            result.add(List.of(entry.shop, entry.movie));
            if (result.size() == 5) break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] entries = {
                {0, 1, 5},
                {0, 2, 6},
                {0, 3, 7},
                {1, 1, 4},
                {1, 2, 7},
                {2, 1, 5}
        };

        MovieRentingSystem mrs = new MovieRentingSystem(3, entries);

        // search(1)
        System.out.println("Search(1): " + mrs.search(1));
        // Expected: [1, 0, 2]

        // rent(0, 1)
        mrs.rent(0, 1);

        // report()
        System.out.println("Report: " + mrs.report());
        // Expected: [[0, 1]]

        // drop(0, 1)
        mrs.drop(0, 1);

        // search(1) again
        System.out.println("Search(1): " + mrs.search(1));
        // Expected: [1, 0, 2]
    }
}
