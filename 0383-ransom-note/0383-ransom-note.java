class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        var charCount = new HashMap<Character, Integer>();
        for(var ch: magazine.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        for(var ch: ransomNote.toCharArray()) {
            if(!charCount.containsKey(ch))
                return false;

            charCount.put(ch, charCount.get(ch) - 1);

            if(charCount.get(ch) < 0)
                return false;
        }

        return true;
    }
}