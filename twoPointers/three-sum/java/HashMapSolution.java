import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
public class HashMapSolution {
    


public List<List<Integer>> threeSum(int[] nums){
    List<List<Integer>> result = new ArrayList<>();
    return result;
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
