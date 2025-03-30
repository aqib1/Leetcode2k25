class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        var mappingStoT = new char[256];
        var mappingTtoS = new char[256];

        for(int i = 0; i < s.length(); i++) {
            if(mappingStoT[s.charAt(i)] == '\u0000'
                    && mappingTtoS[t.charAt(i)] == '\u0000') {
                mappingStoT[s.charAt(i)] = t.charAt(i);
                mappingTtoS[t.charAt(i)] = s.charAt(i);
            } else if(mappingStoT[s.charAt(i)] != t.charAt(i)
                    || mappingTtoS[t.charAt(i)] != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}