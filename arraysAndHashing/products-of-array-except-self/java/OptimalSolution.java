
public class OptimalSolution {
    
    public int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];
        result[0]=1;
        for(int i=1; i<nums.length;i++){
            result[i]=result[i-1]*nums[i-1];
        }
        int postfix=1;
        for(int i=nums.length-1;i>=0;i--){
            result[i]*=postfix;
            postfix*=nums[i];
        }

        return result;
    }

    public static void main(String[] args){

        OptimalSolution solution = new OptimalSolution();
        int[] nums = {1,2,4,6};
        int[] result = solution.productExceptSelf(nums);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
