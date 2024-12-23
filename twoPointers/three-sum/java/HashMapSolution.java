import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HashMapSolution {
    


public List<List<Integer>> threeSum(int[] nums){
    Arrays.sort(nums);
    Map<Integer, Integer> count = new HashMap<>();
    for (int num : nums) {
        count.put(num, count.getOrDefault(num, 0) + 1);
    }

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        count.put(nums[i], count.get(nums[i]) - 1);
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        for (int j = i + 1; j < nums.length; j++) {
            count.put(nums[j], count.get(nums[j]) - 1);
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;

            int target = -(nums[i] + nums[j]);
            if (count.getOrDefault(target, 0) > 0) {
                res.add(Arrays.asList(nums[i], nums[j], target));
            }
        }

        for (int j = i + 1; j < nums.length; j++) {
            count.put(nums[j], count.get(nums[j]) + 1);
        }
    }
    return res;
}

    public static void main(String[] args)
    {
        HashMapSolution solution = new HashMapSolution();
        List<List<Integer>> result;
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        int[] nums1 = new int[]{0,1,1};
        int[] nums2 = new int[]{0,0,0};
        result = solution.threeSum(nums);
        System.out.println(result);
        result = solution.threeSum(nums1);
        System.out.println(result);
        result = solution.threeSum(nums2);
        System.out.println(result);
    }


}
