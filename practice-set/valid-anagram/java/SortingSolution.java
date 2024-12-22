import java.util.Arrays;

public class SortingSolution {

    public static void main(String[] args)
    {
        String s = "racecar";
        String t = "carrace";

        String s1 = "jar";
        String t1 = "jam";

        SortingSolution solution = new SortingSolution();
        boolean result;
        result = solution.isAnagram(s, t);
        System.out.println("Is valid  Anagram :  "+ result);
        result = solution.isAnagram(s1, t1);
        System.out.println("Is not a valid  Anagram :  "+ result);

    }

    public boolean isAnagram(String s , String t)
    {
        if(s.length()!= t.length())
        {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);

    }
}
