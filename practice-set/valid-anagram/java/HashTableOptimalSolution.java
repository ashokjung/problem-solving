public class HashTableOptimalSolution {

  public static void main(String[] args) {
    String s = "racecar";
    String t = "carrace";

    String s1 = "jar";
    String t1 = "jam";

    HashTableOptimalSolution solution = new HashTableOptimalSolution();
    boolean result;
    result = solution.isAnagram(s, t);
    System.out.println("Is valid  Anagram :  " + result);
    result = solution.isAnagram(s1, t1);
    System.out.println("Is not a valid  Anagram :  " + result);

  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    // alphabet in one case is 26 only.
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
      count[t.charAt(i) - 'a']--;
    }
    for (int val : count) {
      if (val != 0) {
        return false;
      }
    }
    return true;
  }
}
