class Solution {
    public boolean isValid(String s) {
         
        var key = Map.of(
                '}', '{',
                ']', '[',
                ')', '('
        );
       var stack = new Stack<Character>();

       for(char ch: s.toCharArray()) {
           if(key.containsKey(ch)) {
               if(stack.isEmpty() || key.get(ch) != stack.pop())
                    return false;
           } else {
               stack.push(ch);
           }
       }

       return stack.isEmpty();
       }
}