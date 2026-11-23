class Solution {
    public boolean isMonotonic(int[] arr) {
        if (arr == null || arr.length == 0)
            return false;
        var increasing = false;
        var decreasing = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i])
                increasing = true;
            if (arr[i - 1] > arr[i])
                decreasing = true;

            if (increasing && decreasing)
                return false;
        }

        return true;
    }
}