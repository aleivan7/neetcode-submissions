class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        if (strs.length <= 1){
            let s = []
            return [strs]
        }

        let d = {}
        let answer = []
        // Build map
        for (let i=0;i<strs.length;i++){
            let element = strs[i].split('').sort().join('')
            if(d[element]){
                d[element].push(strs[i])
            }
            else{
                d[element] = [strs[i]] 
            } 
        }

        for (let key in d) {
            answer.push(d[key])
        }

        return answer
    }
}
