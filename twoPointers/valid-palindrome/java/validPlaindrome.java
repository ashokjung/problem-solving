
public class validPlaindrome {

    public boolean isValidPalindrome(String s)
    {
        int leftpointer = 0;
        int rightpointer = s.length()-1;

        while(leftpointer< rightpointer)
        {
            while(leftpointer < rightpointer && !alphaNumeric(s.charAt(leftpointer)) )
            {
                leftpointer ++;
            }
            while(leftpointer < rightpointer && !alphaNumeric(s.charAt(rightpointer)) )
            {
                rightpointer --;
            }
            if(Character.toLowerCase(s.charAt(leftpointer)) !=
               Character.toLowerCase(s.charAt(rightpointer)))
               {
               return false;
               }
               leftpointer ++;
               rightpointer --;
            
        }

        return true;


    }

    public boolean alphaNumeric(char c)
    {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9'
        );
    }
    
    public static void main(String[] args)
    {
        validPlaindrome solution = new validPlaindrome();
        String input =  "Was it a car or a cat I saw?" ;
        String input1 =  "tab a cat";
        boolean result ; 
        result = solution.isValidPalindrome(input);
        System.out.println(result);
        result = solution.isValidPalindrome(input1);
        System.out.println(result);
    }
}
