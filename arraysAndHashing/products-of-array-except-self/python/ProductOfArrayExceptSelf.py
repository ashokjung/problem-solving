class ProductOfArrayExceptSelf:
    def __init__(self, nums):
        self.nums = nums

    def product_except_self(self):
        length = len(self.nums)
        answer = [1] * length

        left_product = 1
        for i in range(length):
            answer[i] = left_product
            left_product *= self.nums[i]

        right_product = 1
        for i in range(length - 1, -1, -1):
            answer[i] *= right_product
            right_product *= self.nums[i]

        return answer

if __name__ == "__main__":
    nums = [1, 2, 4, 6]
    solution = ProductOfArrayExceptSelf(nums)
    print(solution.product_except_self())