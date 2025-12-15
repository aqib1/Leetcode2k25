class Solution {
    private static final Set<String> OPERATORS = Set.of(
            "+", "-", "*", "/"
    );

    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();
        Arrays.stream(tokens).forEach(
                t -> {
                    if(OPERATORS.contains(t)) {
                        stack.push(performOperation(t, stack.pop(), stack.pop()));
                    } else {
                        stack.push(Integer.parseInt(t));
                    }
                });

        return stack.pop();
    }

    private int performOperation(String t, int pop, int pop1) {
        return switch (t) {
            case "+" -> pop + pop1;
            case "-" -> pop1 - pop;
            case "*" -> pop * pop1;
            case "/" -> pop1 / pop;
            default -> throw new IllegalArgumentException("Operation is invalid");
        };
    }
}