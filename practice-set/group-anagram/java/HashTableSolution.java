import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTableSolution {
    

    public List<List<String>> groupAnagram(String[] strs)
    {
        Map<String,List<String>> result = new HashMap<>();
        for(String s: strs)
        {
            int[] count = new int[26];
            for(char c :s.toCharArray())
            {
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }
        

        return new ArrayList<>(result.values());
    }

    public static void main(String[] args)
    {
        HashTableSolution solution = new HashTableSolution();
        List<List<String>> result;
        String[] string = new String[]{"act","pots","tops","cat","stop","hat"};
        String[] string1 = new String[]{"x"};
        String[] string2 = new String[]{""};
        result= solution.groupAnagram(string);
        System.out.println(result);
        result = solution.groupAnagram(string1);
        System.out.println(result);
        result = solution.groupAnagram(string2);
        System.out.println(string2);
    }

}
