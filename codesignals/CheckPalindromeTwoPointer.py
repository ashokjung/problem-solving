def CheckPalindromeTwoPointer(inputString):
    left = 0
    right = len(inputString) - 1
    
    while left < right:
        if inputString[left] != inputString[right]:
            return False
        left += 1
        right -= 1
    
    return True

# Example usage:
if __name__ == "__main__":
    test_string = "radar"
    print(f"Is '{test_string}' a palindrome? {CheckPalindromeTwoPointer(test_string)}")
    
    test_string2 = "hello"
    print(f"Is '{test_string2}' a palindrome? {CheckPalindromeTwoPointer(test_string2)}")