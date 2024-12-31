using System;

public class BruteForceSolution
{
    public bool ContainsDuplicate(int[] nums)
    {
        for (int i = 0; i < nums.Length; i++)
        {
            for (int j = i + 1; j < nums.Length; j++)
            {
                if (nums[i] == nums[j])
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void Main(string[] args)
    {
        BruteForceSolution solution = new BruteForceSolution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        bool result = solution.ContainsDuplicate(nums);
        Console.WriteLine("Contains duplicate: " + result);
    }
}