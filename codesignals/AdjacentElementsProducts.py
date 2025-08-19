def AdjacentElementsProducts(inputArray):
    if len(inputArray) < 2:
        return 0
    
    max_product = inputArray[0] * inputArray[1]
    
    for i in range(1, len(inputArray) - 1):
        product = inputArray[i] * inputArray[i + 1]
        if product > max_product:
            max_product = product
            
    return max_product

# Example usage:
if __name__ == "__main__":          
    test_array = [3, 6, -2, -5, 7, 3]
    print(f"Maximum product of adjacent elements: {AdjacentElementsProducts(test_array)}")
    
    test_array2 = [1, 2, 3, 0]
    print(f"Maximum product of adjacent elements: {AdjacentElementsProducts(test_array2)}")
    