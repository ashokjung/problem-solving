import java.util.Arrays;

public class HashSetLength {

  public static void main(String[] args) {
    int[] hasDuplicateElement = new int[5];
    hasDuplicateElement[0] = 3;
    hasDuplicateElement[0] = 4;
    hasDuplicateElement[0] = 2;
    hasDuplicateElement[0] = 3;
    hasDuplicateElement[0] = 1;

    int[] hasNoDuplicateElement = new int[]{10, 11, 12, 13, 14};
    boolean result;

    HashSetLength solution = new HashSetLength();
    result = solution.hasduplicate(hasDuplicateElement);
    System.out.println("Check for duplicate element in the array : " + result);
    result = solution.hasduplicate(hasNoDuplicateElement);
    System.out.println("Check for No duplicate element in the array : " + result);

  }

  public boolean hasduplicate(int[] nums) {
    return Arrays.stream(nums).distinct().count() < nums.length;
  }

}
