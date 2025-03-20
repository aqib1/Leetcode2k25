class Solution {
    // time complexity ON(logN) and space O(N)
    public List<List<String>> groupAnagrams(String[] strs) {
        var groupAnagrams = new HashMap<String, List<String>>();
        for(var str: strs) {
            var key = getSortedKey(str);
            if(groupAnagrams.containsKey(key)) {
                groupAnagrams.get(key).add(str);
            } else {
                groupAnagrams.put(key, new ArrayList<>(List.of(str)));
            }
        }

        return new ArrayList<>(groupAnagrams.values());
    }

    private String getSortedKey(String str) {
        var data = str.toCharArray();
        Arrays.sort(data);
        return new String(data);
    }
}