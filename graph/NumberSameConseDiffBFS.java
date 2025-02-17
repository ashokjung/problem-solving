package graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NumberSameConseDiffBFS {

    public static void main(String[] args) {
        NumberSameConseDiffBFS obj = new NumberSameConseDiffBFS();
        int n = 3;
        int k = 7;
        int n1 = 2;
        int k1 = 1;
        int[] result = obj.numSameConsecDiff(n, k);
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        result = null;
        result = obj.numSameConsecDiff(n1, k1);
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public int[] numSameConsecDiff(int n , int k)
    {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= 9; i++)
        {
            q.add(i);
        }

        int len = 1;

        while (!q.isEmpty() && len < n) {
            len++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                int lastDigit = num % 10;
                if (lastDigit + k < 10) {
                    q.add(num * 10 + lastDigit + k);
                }
                if (lastDigit - k >= 0 && k != 0) {
                    q.add(num * 10 + lastDigit - k);
                }
            }
        }

        while (!q.isEmpty() && len == n) {
            res.add(q.poll());
        }
        
        int result[] = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
    return result;

    }
}
