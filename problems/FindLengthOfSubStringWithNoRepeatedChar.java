package problems;

import java.util.HashMap;

/*
 * Given a string S and an integer k, 
 * the task is to return the number of substrings in 
 * S of length k with no repeated characters.
 * Example:
 * Input: S = "geeksforgeeks", k = 5
 * Output: 4
 * Explanation: There are 4 substrings, they are: 'eksfo', 'ksfor', 'sforg', 'forge'.
 * Input: S = "home", k = 5
 * Output: 0
 * Explanation: Notice k can be larger than the length of S. In this case, it is not possible to find any substring.
 */

public class FindLengthOfSubStringWithNoRepeatedChar {

    public int FindLengthOfSubStringWithNoRepeatedChar(String inputString, int inputStringLength){
       
        HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
        int left = 0;
        int right = 0;
        int result = 0;
      
      if(inputStringLength > inputString.length()){
          return 0;
      }
     
      while (right < inputString.length()){
         charMap.put(
            inputString.charAt(right),
            charMap.getOrDefault(inputString.charAt(right),
             0)+1);
        
      while (charMap.get(inputString.charAt(right))>1){
          charMap.put(
            inputString.charAt(left),
            charMap.get(inputString.charAt(left))
            -1);
          left++;
        }

        if(right - left + 1 == inputStringLength){
            result++;
            charMap.put(inputString.charAt(left),
             charMap.get(inputString.charAt(left))-1);
            left++;
        }
            right++;
    }
      return result;
    }

    public static void main(String[] args){
        String inputString1 = "geeksforgeeks";
        int k1 = 5;
        String inputString2 = "home";
        int k2 = 5;
        System.out.println("Distinct Substring for inputString1 is : " + new FindLengthOfSubStringWithNoRepeatedChar().FindLengthOfSubStringWithNoRepeatedChar(inputString1,k1));
        System.out.println("Distinct Substring for inputString2 is : " + new FindLengthOfSubStringWithNoRepeatedChar().FindLengthOfSubStringWithNoRepeatedChar(inputString2,k2));

    }
    
}
