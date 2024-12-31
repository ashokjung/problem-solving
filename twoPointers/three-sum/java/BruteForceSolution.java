import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class BruteForceSolution {
    
public List<List<Integer>> threeSum(int[] nums)
{
   Set<List<Integer>> result = new HashSet<>();
   Arrays.sort(nums);
   for(int i=0 ; i<nums.length;i++)
   {
    for(int j=i+1; j<nums.length;j++)
    {
        for(int k = j+1 ; k< nums.length;k++)
        {
            if(nums[i]+nums[j]+nums[k]==0)
            {
                List<Integer> tmp =  Arrays.asList(nums[i],nums[j],nums[k]);
                result.add(tmp);
            }
        }
     }
   }
   return new ArrayList<>(result);
}
    public static void main(String[] args)
    {
        BruteForceSolution solution = new BruteForceSolution();
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
