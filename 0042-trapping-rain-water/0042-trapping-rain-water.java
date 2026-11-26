class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int trap = 0;
        int[] maxFromLeft = new int[height.length];
        int[] maxFromRight = new int[height.length];

        maxFromLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxFromLeft[i] = Math.max(maxFromLeft[i - 1], height[i]);
        }

        maxFromRight[maxFromRight.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(maxFromRight[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            trap += Math.min(maxFromLeft[i], maxFromRight[i]) - height[i];
        }
        return trap;
    }
}