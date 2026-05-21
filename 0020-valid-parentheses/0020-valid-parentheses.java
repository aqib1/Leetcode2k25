class Solution {
    public boolean isValid(String paran) {
        Map<Character, Character> bracMap = new HashMap<>(
                Map.of(
                        ')', '(',
                        ']', '[',
                        '}', '{'));
        var stack = new Stack<Character>();
        for (char ch : paran.toCharArray()) {
            if (bracMap.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != bracMap.get(ch))
                    return false;
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}