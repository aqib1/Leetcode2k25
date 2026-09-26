class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.equals("1") || num2.equals("1"))
            return num1.equals("1") ? num2 : num1;
        var pos = new int[num1.length() + num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                int prod = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                int n = i + j + 1;
                int sum = pos[n] + prod;

                pos[n] = sum % 10;
                pos[n - 1] += sum / 10;
            }
        }

        var builder = new StringBuilder();
        int idx = 0;
        while (idx < pos.length && pos[idx] == 0) {
            idx++;
        }

        for (int i = idx; i < pos.length; i++)
            builder.append(pos[i]);

        return builder.toString();
    }
}