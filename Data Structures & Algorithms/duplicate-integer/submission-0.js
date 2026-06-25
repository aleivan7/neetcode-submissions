class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    hasDuplicate(nums) {
        if (nums.length <= 1){
            return false
        }
        for(let n in nums){
            let t=nums.pop()
            if(nums.includes(t)) {
                return true
            }
        }

        return false
    }
}
