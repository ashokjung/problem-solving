package oca;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
     public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) { // Traverse from right to left
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop(); // Remove smaller elements
            }
            
            // If stack is not empty, top element is the next greater
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(arr[i]); // Push current element onto the stack
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = nextGreaterElement(arr);
        System.out.println(Arrays.toString(result)); // Output: [5, 10, 10, -1, -1]
    }
}
