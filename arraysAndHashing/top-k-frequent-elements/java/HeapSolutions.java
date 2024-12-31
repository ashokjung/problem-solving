import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
public class HeapSolutions {


public static void main(String[] args)
{

    int[] input1 = {1,2,2,3,3,3};
    int k1 =2;
    int[] input2 = {7,7};
    int k2 = 1;
    int [] result; 
    List<Integer> list = new ArrayList<>();

    HeapSolutions heapSolutions = new HeapSolutions();
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
    for(int num: nums)
    {
        count.put(num,count.getOrDefault(num,0)+1);
    }

    PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)-> a[0]-b[0]);
    for(Map.Entry<Integer,Integer> entry : count.entrySet()){
        heap.offer(new int[] {entry.getValue(),entry.getKey()});
        if(heap.size()>k){
            heap.poll();
        }

    }

    for(int i=0; i<k;i++){
        result[i]= heap.poll()[1];
    }


    return result;

}

    
}
