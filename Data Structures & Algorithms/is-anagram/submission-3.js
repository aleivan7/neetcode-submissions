class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        if (s.length !== t.length){
            return false
        }
        const sArray = s.split("").sort()
        const tArray = t.split("").sort()

        for (let i = 0; i<sArray.length;i++){
            if(sArray[i] !== tArray[i]){
                return false
            }
        }
        return true
    }
}
