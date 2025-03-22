class Solution {
    public void rotate(int[] nums, int k) {
        if(k < 0)
            throw new IllegalArgumentException();

        k = k % nums.length;

        int []rotate = new int[nums.length * 2];
        System.arraycopy(nums, 0, rotate, 0, nums.length);
        System.arraycopy(nums, 0, rotate, nums.length, nums.length);

        System.arraycopy(rotate, nums.length - k, nums, 0, nums.length);

    }
}