package codesignals;

public class AdjacentElementsProduct {
    
    public static void main(String[] args) {
        int[] inputArray = {3, 6, -2, -5, 7, 3};
        int maxProduct = adjacentElementsProduct(inputArray);
        System.out.println("Maximum product of adjacent elements: " + maxProduct);
    }

    public static int adjacentElementsProduct(int[] inputArray) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length - 1; i++) {
            int product = inputArray[i] * inputArray[i + 1];
            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }
}
