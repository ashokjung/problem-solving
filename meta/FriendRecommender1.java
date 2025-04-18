package meta;

import java.util.*;

public class FriendRecommender1 {

    // Sample getFriends implementation (can be replaced with API/db call)
    public static List<Integer> getFriends(int id) {
        Map<Integer, List<Integer>> friendMap = new HashMap<>();
        friendMap.put(1, Arrays.asList(2, 3));
        friendMap.put(2, Arrays.asList(1, 4, 5));
        friendMap.put(3, Arrays.asList(1, 6));
        friendMap.put(4, Arrays.asList(2));
        friendMap.put(5, Arrays.asList(2, 7));
        friendMap.put(6, Arrays.asList(3));
        friendMap.put(7, Arrays.asList(5, 8));
        friendMap.put(8, Arrays.asList(7));

        return friendMap.getOrDefault(id, new ArrayList<>());
    }

    public static Set<Integer> getNthOrderFriends(int id, int n) {
        if (n < 1) return new HashSet<>(); // no 0th-order friends

        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentLevel = new HashSet<>();
        currentLevel.add(id);
        visited.add(id);

        for (int level = 0; level < n; level++) {
            Set<Integer> nextLevel = new HashSet<>();
            for (int person : currentLevel) {
                for (int friend : getFriends(person)) {
                    if (!visited.contains(friend)) {
                        nextLevel.add(friend);
                    }
                }
            }
            visited.addAll(nextLevel); // mark all new nodes as visited
            currentLevel = nextLevel;  // move to the next layer
        }

        return currentLevel;
    }

    public static void main(String[] args) {
        int userId = 1;
        for (int n = 1; n <= 4; n++) {
            Set<Integer> nthFriends = getNthOrderFriends(userId, n);
            System.out.println(n + "-th order friends of user " + userId + ": " + nthFriends);
        }
    }
}
