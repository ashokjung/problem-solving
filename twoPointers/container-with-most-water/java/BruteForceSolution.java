

public class BruteForceSolution {
    public static void main(String[] args)
    {
       int result=0;
       int[] heights = {1,7,2,5,4,7,3,6};
       int[] heights1 = {1,1};

       BruteForceSolution solution = new BruteForceSolution();
       result = solution.maxArea(heights);
       System.out.println(result);
       result= solution.maxArea(heights1);
       System.out.println(result);
    }
    public int maxArea(int[] heights){
        int result = 0;
        for (int i=0; i< heights.length;i++){
            for(int j=i+1; j< heights.length;j++){
                result = Math.max(result, Math.min(heights[i],heights[j])*(j-i));
            }
        }
        return result;
    }
}
