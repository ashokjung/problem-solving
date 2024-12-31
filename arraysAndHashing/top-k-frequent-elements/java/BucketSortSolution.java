import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class BucketSortSolution {


public static void main(String[] args)
{

    int[] input1 = {1,2,2,3,3,3};
    int k1 =2;
    int[] input2 = {7,7};
    int k2 = 1;
    int [] result; 
    List<Integer> list = new ArrayList<>();

    BucketSortSolution heapSolutions = new BucketSortSolution();
    result = heapSolutions.topKFrequentElements(input1, k1);
    for(int num: result){
        list.add(num);
    }
    System.out.println("Top k frequent elements are:" + list);
    list.clear();
    result = heapSolutions.topKFrequentElements(input2, k2);
    for(int num: result){
        list.add(num);
    }
    System.out.println("Top k frequent elements are:" + list);
       

}

public int[] topKFrequentElements(int[] nums, int k){
    int[] result = new int[k];
    Map<Integer,Integer> count = new HashMap<>();
   
    @SuppressWarnings("unchecked")
    List<Integer>[] freqLists = new List[nums.length+1];

    for( int i=0 ; i< freqLists.length; i++){
        freqLists[i] = new ArrayList<>();
    }
    for( int num: nums){
        count.put(num,count.getOrDefault(num,0)+1);
    }

    for(Map.Entry<Integer,Integer> entry : count.entrySet()){
        freqLists[entry.getValue()].add(entry.getKey());
    }

    int index = 0;
    for (int i = freqLists.length-1; i>0 && index < k ; i--){

        for( int number: freqLists[i]){
            result[index++] = number;
            if(index ==k){
                return result;
            }
        }

    }

    return result;
}

    
}
