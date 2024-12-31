import java.util.HashSet;
import java.util.Set;

public class HashSetSolution {

  public static void main(String[] args) {
    int[] hasDuplicateElement = new int[5];
    hasDuplicateElement[0] = 1;
    hasDuplicateElement[1] = 2;
    hasDuplicateElement[2] = 3;
    hasDuplicateElement[3] = 4;
    hasDuplicateElement[4] = 3;
    int[] hasNoDuplicateElement = new int[]{10, 20, 30, 40, 50};
    boolean result;
    HashSetSolution solution = new HashSetSolution();
    result = solution.hasduplicate(hasDuplicateElement);
    System.out.println("Check for duplicate element in the array : " + result);
    result = solution.hasduplicate(hasNoDuplicateElement);
    System.out.println("Check for No duplicate element in the array : " + result);
  }

  public boolean hasduplicate(int[] nums) {
    Set<Integer> data = new HashSet<>();
    for (int num : nums) {
      if (data.contains(num)) {
        return true;
      }
      data.add(num);
    }
    return false;
  }
}
