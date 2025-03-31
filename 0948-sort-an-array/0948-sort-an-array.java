class Solution {
    private int[] nums;
    private int[] temp;
    public int[] sortArray(int[] nums) {
        this.nums = nums;
        this.temp = new int[nums.length];
        mergeSort(0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int start, int end) {
        if(start >= end)
            return;

        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        merge(start, mid, end);
    }

    public void merge(int start, int mid, int end) {
        for(int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }

        int i = start;
        int j = mid + 1;
        int k = start;

        while(i <= mid && j <= end) {
            if(temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }
        
        while(i <= mid) {
            nums[k++] = temp[i++];
        }

        while(j <= end) {
            nums[k++] = temp[j++];
        }
    }
}