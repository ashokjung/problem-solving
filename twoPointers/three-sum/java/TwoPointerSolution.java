import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointerSolution {
    

public List<List<Integer>> threeSum(int[] nums){

    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for(int i=0 ; i< nums.length;i++)
    {
        if(nums[i]>0)
        {
            break;
        }
        if(i>0 && nums[i]== nums[i-1] )
        {
            continue;
        }
        int leftpointer =i+1;
        int rightpointer =nums.length-1;
        while (leftpointer< rightpointer) {
            int sum = nums[i]+nums[leftpointer]+nums[rightpointer];
            if(sum>0)
            {
                rightpointer--;
            }
            else if(sum <0)
            {
                leftpointer++;
            }
            else{
                result.add(Arrays.asList(nums[i],nums[leftpointer],nums[rightpointer]));
                leftpointer++;
                rightpointer--;
                while (leftpointer<rightpointer && nums[leftpointer] ==nums[leftpointer-1]) {
                    leftpointer++;
                }
            }
            
        }

    }

    return result;
}
    public static void main(String[] args)
    {
        TwoPointerSolution solution = new TwoPointerSolution();
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
