package oca;
public class MaxSubarraySum {
    public static int[] findMaxSubarray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        // Extract the subarray
        int[] resultSubarray = new int[end - start + 1];
        System.arraycopy(nums, start, resultSubarray, 0, end - start + 1);

        System.out.println("Maximum Sum: " + maxSum);
        return resultSubarray;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] maxSubarray = findMaxSubarray(nums);
        System.out.print("Longest Contiguous Subarray with Maximum Sum: ");
        for (int num : maxSubarray) {
            System.out.print(num + " ");
        }
    }
}
