class Solution {

    // Time complexity O(n*KLogK) where n are strs and k are character in each string.
    // Space complexity O(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagramMap = new HashMap<String, List<String>>();

        for (var st : strs) {
            var key = st.toCharArray();
            Arrays.sort(key);
            var sorted = new String(key);

            if (anagramMap.containsKey(sorted)) {
                anagramMap.get(sorted).add(st);
            } else {
                anagramMap.put(sorted, new ArrayList<>(List.of(st)));
            }
        }

        return anagramMap.values().stream().toList();
    }
}