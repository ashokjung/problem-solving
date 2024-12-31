import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class OptimalSolution {

    public String encode(List<String> strs){
        StringBuilder result = new StringBuilder();
        for(String s: strs){
            result.append(s.length()).append('#').append(s);
        }
        return result.toString();
    }

    public List<String> decode(String str){

        List<String> result = new ArrayList<>();
        int i =0;
        while(i < str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i=j+1;
            j=i+length;
            result.add(str.substring(i,j));
            i=j;
        }
        return result;
    }

    public static void main(String[] args){
        String[] input = new String[] {"neet","code","love","you"};
        String[] input1 = new String[] {"we","say",":","yes"};
        List<String> decodedList = new ArrayList<>();
        OptimalSolution solution = new OptimalSolution();
        List<String> inputList = Arrays.asList(input);
        List<String> inputList1 = Arrays.asList(input1);
        String encodedString = solution.encode(inputList);
        System.out.println("Encoded String: "+encodedString);
        decodedList = solution.decode(encodedString);
        System.out.println("Decoded List: "+decodedList);
        decodedList.clear();
        String encodedString1 = solution.encode(inputList1);
        System.out.println("Encoded String: "+encodedString1);
        decodedList = solution.decode(encodedString1);
        System.out.println("Decoded List: "+decodedList);
    }
}
