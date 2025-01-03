

public class BruteForceSolution {
   
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] result = new int[n];

        for(int i=0; i<n;i++){
            int product =1;
            for(int j=0;j<n;j++){
                if(i!=j){
                    product*=nums[j];
                }
            }
          result[i]= product;
        }

        return result;
    }

    public static void main(String[] args){
        BruteForceSolution solution = new BruteForceSolution();
        int[] nums = {1,2,4,6};
        int[] result = solution.productExceptSelf(nums);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }   


    }
}
