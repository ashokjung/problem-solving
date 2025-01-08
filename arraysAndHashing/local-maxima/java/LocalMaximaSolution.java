import java.util.List;
import java.util.ArrayList;;

public class LocalMaximaSolution {


    public static void main(String[] args)
    {
        List<Integer> localMaximaList = new ArrayList<Integer>();
        LocalMaximaSolution localMaxima = new LocalMaximaSolution();
        int[] array = {1,2,3,5,7,11,11,12,10,8,5,3,11,12,15,10,7,2,2};
        int[] array1=  {5,1,2,3,5,7,11,11,12,12,10,5,3,11,12,25,25,25,25,25,25,25,12,15,10,7,2,2,17};

        localMaximaList = localMaxima.findlocalMaxima(array);
        System.out.println("Local Maxima in array are: " + localMaximaList);
        localMaximaList.clear();

        localMaximaList = localMaxima.findlocalMaxima(array1);
        System.out.println("Local Maxima in array are: " + localMaximaList);   
        localMaximaList.clear();
    }

    public List<Integer> findlocalMaxima(int[] array)
    {
        List<Integer> localMaxima = new ArrayList<Integer>();

       if ((array.length==0)) 
       {
        return localMaxima; 
       }
      
       if(array.length==1 || array[0]>array[1])
       {
           localMaxima.add(array[0]);
       }    
      
       for(int i=1; i<array.length-1; i++)
       {
           if(array[i] >= array[i-1] && array[i] > array[i + 1])
           {
               localMaxima.add(array[i]);
           }
       }    
     
         if(array[array.length-1]>array[array.length-2])
         {
              localMaxima.add(array[array.length-1]);
         }          
       return localMaxima;

        }
}
