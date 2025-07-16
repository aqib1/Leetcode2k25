import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    private static final Map<Character, Character> PARAM_PAIR = Map.of(
            '}', '{',
            ']', '[',
            ')', '('
    );
    // Time complexity is O(N)
    // Space complexity is O(N)
    public boolean isValid(String s) {
       var stack = new Stack<Character>();
        var openingParam = new HashSet<>(PARAM_PAIR.values());
        for (char ch : s.toCharArray()) {
            if (PARAM_PAIR.containsKey(ch)) {
                if (stack.isEmpty() || PARAM_PAIR.get(ch) != stack.pop()) {
                    return false;
                }
            } else if (openingParam.contains(ch)) {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}