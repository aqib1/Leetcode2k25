class Solution {
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

        odd = Arrays.stream(odd)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        even = Arrays.stream(even)
                .boxed()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();


        j = 0; k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                nums[i] = even[j++];
            } else {
                 nums[i] = odd[k++];
            }
        }

        return nums;
    }
}