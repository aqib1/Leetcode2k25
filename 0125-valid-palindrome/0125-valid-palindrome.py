import re
class Solution:
    def isPalindrome(self, s: str) -> bool:
        regex = '[^A-Za-z0-9]+'
        s = re.sub(regex, '', s).lower()
        lastIndex = -1
        for i in range(len(s)):
            if s[i] != s[lastIndex]:
                return False
            lastIndex -= 1;     
        
        return True