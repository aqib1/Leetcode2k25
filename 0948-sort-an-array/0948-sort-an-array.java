class Solution {
    // Time complexity O(NLog(N)) [Linear Arithmatic ] and Space O(N)
    private int[] data;
    private int[] temp;
    private BiPredicate<Integer, Integer> rule;

    public int[] sortArray(int[] nums) {
        this.data = nums;
        this.temp = new int[nums.length];
        this.rule = (a, b) -> a < b;
        mergeSort(0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] data, BiPredicate<Integer, Integer> rule) {
        this.data = data;
        this.temp = new int[data.length];
        this.rule = rule;
        mergeSort(0, data.length - 1);
    }

    public void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    public void merge(int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = data[i];
        }
        int i = left;
        int k = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (rule.test(temp[i], temp[j])) {
                data[k++] = temp[i++];
            } else {
                data[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            data[k++] = temp[i++];
        }

        while (j <= right) {
            data[k++] = temp[j++];
        }
    }
}