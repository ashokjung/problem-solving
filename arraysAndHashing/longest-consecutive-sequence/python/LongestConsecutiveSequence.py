class LongestConsecutiveSequence:
    def longestConsecutive(self, nums):
        if not nums:
            return 0
        nums = set(nums)
        max_len = 1
        while nums:
            first = last = nums.pop()
            while first - 1 in nums:
                first -= 1
                nums.remove(first)
            while last + 1 in nums:
                last += 1
                nums.remove(last)
            max_len = max(max_len, last - first + 1)
        return max_len