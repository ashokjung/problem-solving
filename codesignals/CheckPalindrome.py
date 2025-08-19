def CheckPalindrome(inputString):
    return inputString == inputString[::-1]

# Example usage:
if __name__ == "__main__":
    test_string = "radar"
    print(f"Is '{test_string}' a palindrome? {CheckPalindrome(test_string)}")
    
    test_string2 = "hello"
    print(f"Is '{test_string2}' a palindrome? {CheckPalindrome(test_string2)}")
    