package codesignals;
import java.util.Arrays;

public class MakeArrayConsecutive {

    public static void main(String[] args) {
        int[] statues = {6, 2, 3, 8};
        int result = makeArrayConsecutive(statues);
        System.out.println("Number of additional statues needed: " + result);
    }

    public static int makeArrayConsecutive(int[] statues) {
      
        Arrays.sort(statues);
        return statues[statues.length - 1] - statues[0] + 1 - statues.length;
    }
}