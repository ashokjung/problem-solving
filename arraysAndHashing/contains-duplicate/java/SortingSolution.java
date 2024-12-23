import java.util.Arrays;

public class SortingSolution {

  public static void main(String[] args) {
    int[] hasDuplicateElement = new int[5];
    hasDuplicateElement[0] = 1;
    hasDuplicateElement[1] = 2;
    hasDuplicateElement[2] = 3;
    hasDuplicateElement[3] = 4;
    hasDuplicateElement[4] = 3;
    int[] hasNoDuplicateElement = new int[]{1, 2, 3, 4, 5};
    boolean result;

    SortingSolution solution = new SortingSolution();
    result = solution.hasduplicate(hasDuplicateElement);
    System.out.println("Check for duplicate element in array :  " + result);
    result = solution.hasduplicate(hasNoDuplicateElement);
    System.out.println("Check for No duplicate element in array :  " + result);

  }

  public boolean hasduplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        return true;
      }
    }
    return false;
  }

}
