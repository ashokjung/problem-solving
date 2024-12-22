public class BruteForceSolution {

  public static void main(String[] args) {

    int[] nums = new int[]{3, 4, 5, 6};
    int target = 7;

    int[] nums1 = new int[]{4, 5, 6};
    int target1 = 10;

    int[] nums2 = new int[]{5, 5};
    int target2 = 10;
    int[] nums3 = new int[]{2, 5, 5, 11};
    int target3 = 10;
    BruteForceSolution solution = new BruteForceSolution();
    int[] result = new int[2];

    result = solution.twoSum(nums, target);
    System.out.println("index are  : " + result[0] + "," + result[1]);

    result = solution.twoSum(nums1, target1);
    System.out.println("index are  : " + result[0] + "," + result[1]);

    result = solution.twoSum(nums2, target2);
    System.out.println("index are  : " + result[0] + "," + result[1]);

    result = solution.twoSum(nums3, target3);
    System.out.println("index are  : " + result[0] + "," + result[1]);
  }

  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
          if (nums[i] + nums[j] == target) {
              return new int[]{i, j};
          }
      }
    }

    return new int[]{};
  }
}
