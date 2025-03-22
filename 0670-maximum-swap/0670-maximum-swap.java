class Solution {
    // Greedy approach with extra space
    // Time complexity O(n) and space O(n)
    public int maximumSwap(int num) {
       var numData = String.valueOf(num).toCharArray();
        int maxValueIndex = numData.length - 1;
        int swap1 = -1, swap2 = maxValueIndex;

        for(int i = numData.length - 2; i >= 0; i--) {
            if(numData[i] > numData[maxValueIndex]) {
                maxValueIndex = i;
            } else if(numData[i] < numData[maxValueIndex]) {
                swap1 = i;
                swap2 = maxValueIndex;
            }
        }

        if(swap1 != -1) {
            var tmp = numData[swap1];
            numData[swap1] = numData[swap2];
            numData[swap2] = tmp;
        }

        return Integer.parseInt(new String(numData));
    }
}