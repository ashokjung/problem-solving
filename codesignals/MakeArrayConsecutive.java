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
        int minStatue = statues[0];
        int maxStatue = statues[statues.length - 1];
        int totalStatues = maxStatue - minStatue + 1;
        return totalStatues - statues.length;
    }
}