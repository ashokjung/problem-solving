
package codesignals;
public class CheckPalindrome{

public static void main(String[] args) {
    String inputString = "radar";
    boolean isPalindrome = checkPalindrome(inputString);
    System.out.println("Is the string \"" + inputString + "\" a palindrome? " + isPalindrome);

}

public static boolean checkPalindrome(String inputString){
    int left =0;
    int right = inputString.length()-1;
    while(left< right){
        if(inputString.charAt(left)!=inputString.charAt(right)){
            return Boolean.FALSE;
        }
        left++;
        right--;
    }
    return Boolean.TRUE;
}
}

