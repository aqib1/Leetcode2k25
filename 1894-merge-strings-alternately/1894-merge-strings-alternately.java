class Solution {
    public String mergeAlternately(String word1, String word2) {
        var builder = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int limit = Math.min(len1, len2);

        for (int x = 0; x < limit; x++) {
            builder.append(word1.charAt(x)).append(word2.charAt(x));
        }


        return (len1 > len2) ? builder.append(word1.substring(limit)).toString() :
                builder.append(word2.substring(limit)).toString();
    }
}