class Solution {

    // Time complexity O(n*m) where n are strs and m are character in each string.
    // Space complexity O(n + m)
    public List<List<String>> groupAnagrams(String[] strs) {
        var anagramMap = new HashMap<String, List<String>>();
        for (var st : strs) {
            var key = getKeyFaster(st);
            if (anagramMap.containsKey(key)) {
                anagramMap.get(key).add(st);
            } else {
                anagramMap.put(key, new ArrayList<>(List.of(st)));
            }
        }
        return anagramMap.values().stream().toList();
    }

    private static String getKeyFaster(String st) {
        var count = new char[26];
        for(char ch: st.toCharArray()) count[ch - 'a']++;
        return String.valueOf(count);
    }
}