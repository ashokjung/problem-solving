import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingMethod {
    

    public static void main(String[] args)
    {
        SortingMethod sortingMethod = new SortingMethod();
        int[] input1 = {1,2,2,3,3,3};
        int k1 =2;
        int[] input2 = {7,7};
        int k2 = 1;
        int [] result;  
            
        result= sortingMethod.topkFrequent(input1, k1);
        List<Integer> lis = new ArrayList<>();
        for( int num: result){
            lis.add(num);
        }
        System.out.println("Top k frequent elements are:" + lis);

        result= sortingMethod.topkFrequent(input2, k2);
        lis.clear();
        for(int num: result){
            lis.add(num);
        }
        System.out.println("Top k frequent elements are:" + lis);

    }

    public int[] topkFrequent(int[] nums, int k){
        int[] result = new int[k];
        
        Map<Integer,Integer> count = new HashMap<>();
        for(int num: nums)
        {
            count.put(num,count.getOrDefault(num,0)+1);
        }
        List<int[]> array = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: count.entrySet())
        {
            array.add(new int[] {entry.getValue(), entry.getKey()});
            
        }
        
        array.sort((a,b)-> b[0]-a[0]);
        for(int i=0;i<k;i++)
        {
            result[i] = array.get(i)[1];
        }

        return result;

    }
}
