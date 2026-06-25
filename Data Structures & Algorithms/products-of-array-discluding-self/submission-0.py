class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        product_array = []
        for i in range(0, len(nums), 1):
            temp_val = 1
            for j in range(0, len(nums), 1):
                if(i == j):
                    pass
                else:
                    temp_val *= nums[j]
            product_array.append(temp_val)
        return product_array
        