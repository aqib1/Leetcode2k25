class Solution {
    public double average(int[] salary) {
       var min = salary[0];
        var max = salary[0];
        var sum = 0;

        for(var s: salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }

        return (double)(sum - max - min) / (salary.length - 2);
    }
}