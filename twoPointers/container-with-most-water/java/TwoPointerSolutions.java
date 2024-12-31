
public class TwoPointerSolutions {

    public int maxArea(int[] heights){
        int result=0;

        int leftPointer = 0; 
        int rightPointer = heights.length-1;

        while(leftPointer< rightPointer){
            int area = Math.min(heights[leftPointer],heights[rightPointer]) * (rightPointer-leftPointer);
            result = Math.max(result,area);
            if(heights[leftPointer]<heights[rightPointer]){
                leftPointer++;
        }
        else{
            rightPointer--;
        }
    }
        return result;
    }
    
    public static void main(String[] args){
        TwoPointerSolutions twoPointerSolutions = new TwoPointerSolutions();
        int result=0;
        int[] heights = {1,7,2,5,4,7,3,6};
        int[] heights1 = {1,1};
 
        result = twoPointerSolutions.maxArea(heights);
        System.out.println(result);

        result = twoPointerSolutions.maxArea(heights1);
        System.out.println(result);
    }
}
