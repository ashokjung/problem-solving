package meta;
import java.util.*;

public class FriendRecommender {

    // This method should be implemented to return a list of friends for a given id.
    public static List<Integer> getFriends(int id) {
        // Example static data (replace with real data source or API)
        Map<Integer, List<Integer>> friendMap = new HashMap<>();
        friendMap.put(1, Arrays.asList(2, 3));
        friendMap.put(2, Arrays.asList(1, 4, 5));
        friendMap.put(3, Arrays.asList(1, 6));
        friendMap.put(4, Arrays.asList(2));
        friendMap.put(5, Arrays.asList(2));
        friendMap.put(6, Arrays.asList(3));

        return friendMap.getOrDefault(id, new ArrayList<>());
    }

    public static List<Integer> getFriendRecommendations(int id) {
        Set<Integer> directFriends = new HashSet<>(getFriends(id));
        Map<Integer, Integer> mutualFriendCounts = new HashMap<>();

        for (int friend : directFriends) {
            for (int fof : getFriends(friend)) {
                if (fof != id && !directFriends.contains(fof)) {
                    mutualFriendCounts.put(fof, mutualFriendCounts.getOrDefault(fof, 0) + 1);
                }
            }
        }

        // Convert to list and sort by mutual friend count (descending)
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(mutualFriendCounts.entrySet());
        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Extract sorted user IDs
        List<Integer> recommendations = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sortedEntries) {
            recommendations.add(entry.getKey());
        }

        return recommendations;
    }

    public static void main(String[] args) {
        List<Integer> recommendations = getFriendRecommendations(1);
        System.out.println("Friend Recommendations for user 1: " + recommendations);
    }
}
