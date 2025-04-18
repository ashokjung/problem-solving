package meta;
import java.util.HashMap;
import java.util.Map;

public class CustomSort {
    public static String customSort(String input, String order) {
        Map<Character, Integer> countMap = new HashMap<>();

        // Count occurrences of each character in input
        for (char c : input.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        // Append characters in the order specified
        for (char c : order.toCharArray()) {
            int count = countMap.getOrDefault(c, 0);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "abcab";
        String order = "bca";

        String output = customSort(input, order);
        System.out.println(output); // Output: bbcaa
    }
}
