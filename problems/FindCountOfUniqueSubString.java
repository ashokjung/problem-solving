package problems ;

import java.util.HashSet;

/*
 * 
 * Given a string str consisting of lowercase characters, 
 * the task is to find the total number of unique substrings
 *  with non-repeating characters.
 * Input: str = “abba” 
 * Output: 4 
 * Explanation: There are 4 unique substrings. They are: “a”, “ab”, “b”, “ba”.
 * Input: str = “acbacbacaa” 
 * Output: 10 
 * 
 * 
 */

public class FindCountOfUniqueSubString {

   public int distinctSubString(String inputString){
    int result = 0; 
    int length = inputString.length();
    HashSet<String> stringHashSet = new HashSet<String>();
    String resultString = "";
        for(int i=0;i<length;i++){
          boolean[] freq = new boolean[26];
          for(int j=i; j<length;j++){
           int position = inputString.charAt(j)-'a';
           if(freq[position] ==true){
               break;
          } 
          freq[position] = true;
        }
        resultString += inputString.charAt(i);
        stringHashSet.add(resultString);
        }
        result = stringHashSet.size();

    return result;

   }

    public static void main(String[] args){
        String inputString1 = "abba";
        String inputString2 = "acbacbacaa";
        System.out.println("Distinct Substring for inputString1 is : " + new FindCountOfUniqueSubString().distinctSubString(inputString1));
        System.out.println("Distinct Substring for inputString2 is : " + new FindCountOfUniqueSubString().distinctSubString(inputString2));

    }

    
}
