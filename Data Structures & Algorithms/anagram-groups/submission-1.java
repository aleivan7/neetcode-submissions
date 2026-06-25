class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            // 1. Sort the string's characters to create a unique "signature" key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String signature = new String(chars);

            // 2. Add the original string to its signature group
            groups.computeIfAbsent(signature, k -> new ArrayList<>()).add(s);
        }

        // 3. Return all the grouped lists
        return new ArrayList<>(groups.values());
    }
}
