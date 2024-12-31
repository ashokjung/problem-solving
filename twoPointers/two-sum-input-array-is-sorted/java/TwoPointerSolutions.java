import java.util.ArrayList;
import java.util.List;



public class TwoPointerSolutions {

    public int[] twoSum(int[] nums, int target)
    {
        int leftPointer =0;
        int rightPointer = nums.length-1;

       while(leftPointer<rightPointer){

            int currentSum = nums[leftPointer] + nums[rightPointer];
            if(currentSum >target){
                rightPointer--;
            }
            else if(currentSum < target){   
                leftPointer++;  
            }
            else{
                return new int[]{leftPointer+1,rightPointer+1};
            }
         }
     return new int[0];

    }

    public static void main(String[] args){

        int[] nums = new int[]{1,2,3,4};
        int target = 3;
        int[] result = new int[2];
        TwoPointerSolutions twoPointerSolutions = new TwoPointerSolutions();
        result = twoPointerSolutions.twoSum(nums, target);
        System.out.println("index are : "+ result[0] +"," + result[1]);
        List<Integer> list = new ArrayList<>();
        for (int num: result)
        {
            list.add(num);
        }
        System.out.println("index are : " + list);  
    }
    
}
