class Solution {

    // Time complexity O(M*KLogk) where N is numbers of strs and K avg length of a string
    // Space complexity O(N*M)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return List.of();
        var anagramMap = new HashMap<String, List<String>>();
        for (var str : strs) {
            var ch = str.toCharArray();
            Arrays.sort(ch);
            var key = String.valueOf(ch);
            if (anagramMap.containsKey(key)) {
                anagramMap.get(key).add(str);
            } else {
                anagramMap.put(key, new ArrayList<>(List.of(str)));
            }
        }
        return anagramMap.values().stream().toList();
    }
}