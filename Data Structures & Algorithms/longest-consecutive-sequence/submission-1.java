class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // 1. Add all numbers to a set (removes duplicates automatically)
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxSeq = 0;

        // 2. Look for the start of sequences
        for (int num : numSet) {
            // Check if 'num' is the absolute beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentSeq = 1;

                // Track how far this specific sequence goes
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentSeq += 1;
                }

                maxSeq = Math.max(maxSeq, currentSeq);
            }
        }

        return maxSeq;
    }
}
