class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        if (nums.length === 2 && nums[0]+nums[1] === target){
            return [0,1]
        }
        let response = []
        for (let i=0; i<nums.length; i++) {
            for (let j=1; j<nums.length; j++) {
                if ((nums[i]+nums[j]===target) && (i !== j)){
                    return [nums.indexOf(nums[i]), nums.lastIndexOf(nums[j])]
                }
            }
        }
    }
}
