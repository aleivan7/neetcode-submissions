class Solution {
    public int longestConsecutive(int[] nums) {
         if (nums == null || nums.length == 0) {
            return 0;
        }
        //sort the array
        Arrays.sort(nums);
        //Create set of array  to remove duplicates
        int[] uniqueNums = Arrays.stream(nums).distinct().toArray();
        //Traverse Array and return longest consecutive sequence
        int maxSeq = 1;
        int currentSeq = 1;
        for(int i=0; i< uniqueNums.length - 1; i++){
            if((uniqueNums[i+1] - uniqueNums[i]) == 1){
                currentSeq++;
            }
            else{
                maxSeq = Math.max(maxSeq, currentSeq);
                currentSeq = 1; 
            }
        }
        return Math.max(maxSeq, currentSeq);
    }
}
