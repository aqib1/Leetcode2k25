class Solution {
    // Time complexity ON(LogN) and space complexity O(n)
    public int[] sortEvenOdd(int[] nums) {
        int evenLen = nums.length % 2 == 0 ?
                nums.length / 2 : (nums.length / 2) + 1;
        int oddLen = nums.length / 2;

        var even = new int[evenLen];
        var odd  = new int[oddLen];

        int j = 0, k = 0;
        for(int i = 0; i < nums.length;  i++) {
            if(i % 2 == 0) {
                even[j++] = nums[i];
            } else {
                odd[k++] = nums[i];
            }
        }

        Arrays.sort(even);
        Arrays.sort(odd);


        j = 0; k = odd.length - 1;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                nums[i] = even[j++];
            } else {
                 nums[i] = odd[k--];
            }
        }

        return nums;
    }
}