class Solution {

    // Time complexity O(n*KLogK) where n are strs and k are character in each string.
    // Space complexity O(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagramMap = new HashMap<String, List<String>>();
        for (var st : strs) {
            var key = getSortedKey(st);
            if (anagramMap.containsKey(key)) {
                anagramMap.get(key).add(st);
            } else {
                anagramMap.put(key, new ArrayList<>(List.of(st)));
            }
        }
        return anagramMap.values().stream().toList();
    }

    private static String getSortedKey(String st) {
        var key = st.toCharArray();
        Arrays.sort(key);
        return new String(key);
    }
}