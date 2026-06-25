class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left = [1] * len(nums)
        right = [1] * len(nums)
        answer = [1] * len(nums)

        for i, j in zip(range(1, len(nums)), range(len(nums)-2, -1, -1)):
            left[i] = left[i-1] * nums[i-1]
            right[j] = right[j + 1] * nums[j + 1]

        for i in range(0, len(nums)):
            answer[i] = left[i] * right[i]

        return answer
            
