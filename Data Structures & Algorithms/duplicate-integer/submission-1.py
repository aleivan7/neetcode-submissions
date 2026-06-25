class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        while len(nums) > 0:
            prev = nums[0]    
            for i in range(1,len(nums)):
                if prev == nums[i]:
                    return True
            nums.pop(0)
        return False
        