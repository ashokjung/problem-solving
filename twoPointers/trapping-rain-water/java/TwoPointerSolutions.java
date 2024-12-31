
public class TwoPointerSolutions {
    public int trapRainWater(int[] height){
        int result= 0;
        int leftPointer =0;
        int rightPointer = height.length -1;
        int leftMax = height[leftPointer];
        int rightMax = height[rightPointer];
        if(height==null || height.length==0)
        {
            return 0;
        }
        while(leftPointer< rightPointer)
        {
            if(leftMax< rightMax){
                leftPointer++;
                leftMax = Math.max(leftMax, height[leftPointer]);
                result+=leftMax-height[leftPointer];
            }
            else{
                rightPointer--;
                rightMax = Math.max(rightMax, height[rightPointer]);
                result+=rightMax-height[rightPointer];
         }
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = new int[]{0,2,0,3,1,0,1,3,2,1};
        TwoPointerSolutions solution = new TwoPointerSolutions();
        int result= solution.trapRainWater(input);
        System.out.println("The trapped rain water is : "+ result);
    }  
}
