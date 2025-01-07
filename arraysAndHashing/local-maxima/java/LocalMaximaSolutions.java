import java.util.List;
import java.util.ArrayList;

public class LocalMaximaSolutions {
    
public List<Integer> findlocalMaxima(int [] array)
{
    List<Integer> localMaximaList = new ArrayList<Integer>();
    int i =0;
    int j=1;
    int arrayLength = array.length;
        if(arrayLength==0)
        {
            return localMaximaList;
        }
        if(arrayLength==1)
        {
            localMaximaList.add(array[0]);
            return localMaximaList;
        }
        if(arrayLength==2)
        {
            if(array[0]>array[1])
            {
                localMaximaList.add(array[0]);
            }
           else
            {
                localMaximaList.add(array[1]);
            }
            return localMaximaList;
        }
       while (j< arrayLength-1)
       {
           if(array[i]<= array[j] && array[j]>array[j+1])
           {
               localMaximaList.add(array[j]);
           }
           if(i==0 && array[i] > array[j] )
           {
            localMaximaList.add(array[i]);
           }
           if(array[j]!= array[j+1])
           {
            i=j;
           }
           j++;
       }
       if(array[i]<= array[j])
       {
           localMaximaList.add(array[j]);
       }
    return localMaximaList;
}

public static void main(String[] args)
{
    List<Integer> localMaximaList = new ArrayList<Integer>();
    LocalMaximaSolutions localMaxima = new LocalMaximaSolutions();
    int[] input = {1,2,3,5,7,11,11,12,10,8,5,3,11,12,15,10,7,2,2};
    int[] input1=  {5,1,2,3,5,7,11,11,12,12,10,5,3,11,12,25,25,25,25,25,25,25,12,15,10,7,2,2,17};   
    localMaximaList = localMaxima.findlocalMaxima(input);   
    System.out.println("Local Maxima in array are: " + localMaximaList);
    localMaximaList.clear();
    localMaximaList = localMaxima.findlocalMaxima(input1);
    System.out.println("Local Maxima in array are: " + localMaximaList);    
}

}
