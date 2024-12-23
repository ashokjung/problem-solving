import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;


public class SortingSolution {


  public static void main(String[] args) {
    SortingSolution solution = new SortingSolution();
    List<List<String>> result;
    String[] string = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};
    String[] string1 = new String[]{"x"};
    String[] string2 = new String[]{""};
    result = solution.groupAnagram(string);
    System.out.println(result);
    result = solution.groupAnagram(string1);
    System.out.println(result);
    result = solution.groupAnagram(string2);
    System.out.println(string2);
  }

  public List<List<String>> groupAnagram(String[] strs) {
    Map<String, List<String>> result = new HashMap<>();
    for (String s : strs) {
      char[] charArray = s.toCharArray();
      Arrays.sort(charArray);
      String sortedString = new String(charArray);
      result.putIfAbsent(sortedString, new ArrayList<>());
      result.get(sortedString).add(s);

    }


    return new ArrayList<>(result.values());
  }

}
