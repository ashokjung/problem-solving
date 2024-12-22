import java.util.HashMap;

public class HashMapSolutionOnepass {
   
    public static void main(String[] args)
    {
    
        int[] nums = new int[]{3,4,5,6};
        int target =7;

        int[] nums1 = new int[]{4,5,6};
        int target1 =10;

        int[] nums2 = new int[]{5,5};
        int target2 =10;

        HashMapSolutionOnepass solution = new HashMapSolutionOnepass();
        int[] result = new int[2];

        result= solution.twoSum(nums, target);
        System.out.println("index are  : "+result[0]  + "," +result[1]);

        result= solution.twoSum(nums1, target1);
        System.out.println("index are  : "+result[0] + ","   + result[1]);
    
        result= solution.twoSum(nums2, target2);
        System.out.println("index are  : "+result[0] + ","  + result[1]);
    }

    public int[] twoSum(int[] nums,int target)
    {
         HashMap<Integer,Integer> hashMap = new HashMap<>();

         for(int i=0; i< nums.length; i++)
         {
            int num = nums[i];
            int difference = target-num;
            if(hashMap.containsKey(difference))
            {
                return new int[]{hashMap.get(difference),i};
            }
            hashMap.put(num, i);
         }

        return new int[0];
    }

}
