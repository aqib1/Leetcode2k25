class Solution {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;

        var trap = 0;
        var maxFromLeft = new int[height.length];
        var maxFromRight = new int[height.length];

        maxFromLeft[0] = height[0];
        for (int i = 1; i < maxFromLeft.length; i++) {
            maxFromLeft[i] = Math.max(maxFromLeft[i - 1], height[i]);
        }

        maxFromRight[maxFromRight.length - 1] = height[maxFromRight.length - 1];
        for (int j = maxFromRight.length - 2; j >= 0; j--) {
            maxFromRight[j] = Math.max(height[j], maxFromRight[j + 1]);
        }

        for (int k = 0; k < height.length; k++) {
            trap += (Math.min(maxFromLeft[k], maxFromRight[k]) - height[k]);
        }

        return trap;
    }
}