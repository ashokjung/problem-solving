package graph;
import java.util.ArrayList;
import java.util.List;

public class NumberSameConseDiffDFS {

    public static void main(String[] args) {
        NumberSameConseDiffDFS obj = new NumberSameConseDiffDFS();
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

            for(int i = 1; i <= 9; i++)
            {
                dfs(i, n-1, k, res);
            }

        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
        {
            result[i] = res.get(i);
        }
        return result;

    }

    private void dfs(int num, int n, int k, List<Integer> res)
    {
        if(n == 0)
        {
            res.add(num);
            return;
        }

        int lastDigit = num % 10;

        if(lastDigit + k < 10)
        {
            dfs(num * 10 + lastDigit + k, n-1, k, res);
        }

        if(lastDigit - k >= 0 && k != 0)
        {
            dfs(num * 10 + lastDigit - k, n-1, k, res);
        }
    }

}
