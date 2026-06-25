class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(0,len(nums)):
            for j in range(1, len(nums)):
                if i == j:
                    pass
                else:
                    s = nums[i] + nums[j]
                    if target == s:
                        return [i,j]
        