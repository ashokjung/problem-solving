import java.util.ArrayList;
import java.util.List;  
public class BruteForceSolution {

    public static void main(String[] args){
         int [] input = new int[] {1,2,3,4};
         int target = 3;
         int [] result = new int[2];
         BruteForceSolution bruteForceSolution  = new BruteForceSolution();
         
         result = bruteForceSolution.twoSum(input, target);
         System.out.println("index are  : "+result[0]  + "," +result[1]);

         List<Integer> list = new ArrayList<>();
        for(int num: result)
        {
            list.add(num);
        }
         System.out.println("index are  : " + list);


    }

    public int[] twoSum(int[] nums, int target){
        
        
        for(int i=0; i< nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[0];
  
    }
    
}
