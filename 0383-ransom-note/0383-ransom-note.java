class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        var count = new int[26];
        for(var m: magazine.toCharArray()) {
            count[m - 'a']++;
        }
        for(var r: ransomNote.toCharArray()) {
            if(--count[r - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}