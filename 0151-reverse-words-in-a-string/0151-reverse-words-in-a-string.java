class Solution {
    public String reverseWords(String w) {
        w = w.trim();
        var stack = new Stack<String>();
        var split = w.split(" ");
        IntStream.range(0, split.length)
                .filter(x -> !split[x].isBlank())
                .forEach(x -> stack.push(split[x].trim()));
        var builder = new StringBuilder();
        while (!stack.isEmpty())
            builder.append(stack.pop()).append(" ");
        return builder.toString().trim();
    }
}