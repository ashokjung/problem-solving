using System;
using System.Collections.Generic;


public class ProductOfArrayExceptSelf
{
    public static void Main(string[] args)
    {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] nums = { 1, 2, 4, 6 };
        int[] result = solution.GetProductExceptSelf(nums);

        Console.WriteLine("Product of array except self:");
        foreach (int num in result)
        {
            Console.Write(num + " ");
        }
    }
    public int[] GetProductExceptSelf(int[] nums)
    {
        int n = nums.Length;
        int[] result = new int[n];
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        leftProducts[0] = 1;
        for (int i = 1; i < n; i++)
        {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
        {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++)
        {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }
}
  