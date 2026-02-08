class Solution {
    // Time complexity O(n*mLogm)
    // Space complexity O(n*m)
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
            return List.of();
        var anagramMap = new HashMap<String, List<String>>();
        for(var str: strs) {
            var key = getKey(str);
            if(anagramMap.containsKey(key)) {
                anagramMap.get(key).add(str);
            } else {
                anagramMap.put(key, new ArrayList<>(List.of(str)));
            }
        }

        return anagramMap.values().stream().toList();
    }

    private String getKey(String key) {
        var data = key.toCharArray();
        Arrays.sort(data);
        return String.valueOf(data);
    }

}