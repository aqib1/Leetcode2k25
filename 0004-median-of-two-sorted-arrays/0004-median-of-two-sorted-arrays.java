class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            var tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int min = 0;
        int max = nums1.length;

        int x = 0, y = 0;
        boolean isOdd = (nums1.length + nums2.length) % 2 != 0;
        double median = 0.0;

        while (min <= max) {
            x = (min + max) / 2;
            y = ((nums1.length + nums2.length + 1) / 2) - x;

            if (x > 0 && y < nums2.length && nums1[x - 1] > nums2[y]) {
                max = x - 1;
            } else if (y > 0 && x < nums1.length && nums2[y - 1] > nums1[x]) {
                min = x + 1;
            } else {
                if (x == 0) {
                    median = nums2[y - 1];
                } else if (y == 0) {
                    median = nums1[x - 1];
                } else {
                    median = Math.max(nums1[x - 1], nums2[y - 1]);
                }

                break;
            }
        }

        if (isOdd)
            return median;
        if (x == nums1.length) {
            return (median + nums2[y]) / 2.0;
        }
        if (y == nums2.length) {
            return (median + nums1[x]) / 2.0;
        }
        return (median + Math.min(nums1[x], nums2[y])) / 2.0;

    }
}