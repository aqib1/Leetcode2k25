import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        var stack = new Stack<Integer>();

        for (var op : operations) {
            if (isNumeric(op)) {
                stack.push(Integer.parseInt(op));
            } else if ("C".equals(op) && !stack.isEmpty()) {
                stack.pop();
            } else if ("D".equals(op) && !stack.isEmpty()) {
                stack.push(stack.peek() * 2);
            } else if ("+".equals(op) && stack.size() >= 2) {
                var first = stack.pop();
                var second = stack.pop();
                stack.push(second);
                stack.push(first);
                stack.push(first + second);
            }
        }

        var sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static boolean isNumeric(String str) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(str, pos);
        return pos.getIndex() == str.length();
    }
}