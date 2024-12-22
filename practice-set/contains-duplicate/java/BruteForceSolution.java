
public class BruteForceSolution
{
    
 public boolean hasduplicate(int[] nums)
 {
   for(int i=0; i< nums.length;i++)
   {
    for(int j=i+1; j<nums.length;j++)
    {
        if(nums[i]== nums[j])
        return true;
    }
   }
   return false;

 }

 public static void main(String[] args)
 {
    int[] duplicateElementInArray = new int[5];
    duplicateElementInArray[0]=1;
    duplicateElementInArray[1]=1;
    duplicateElementInArray[2]=2;
    duplicateElementInArray[3]=3;
    duplicateElementInArray[4]=4;
    
    int[] noduplicateElementInArray = {10, 20, 30, 40, 50};
    
    BruteForceSolution solution = new BruteForceSolution();
    boolean result = solution.hasduplicate(duplicateElementInArray);
    System.out.println("Check for duplicate array input" +"  " + result);
    result = solution.hasduplicate(noduplicateElementInArray);
    System.out.println("Check for no duplicate array input" +"  "+ result);
 }

}