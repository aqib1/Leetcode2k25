class Solution {
    // Time complexity 0(n) and space complexity O(1)
public:
    void rotate(vector<int>& nums, int k) {
        k = k % nums.size();
        reverse(nums, 0, nums.size() - 1);
        // reverse first k numbers
        reverse(nums, 0, k - 1);
        // reverse all except first k
        reverse(nums, k, nums.size() - 1);
    }

    void reverse(vector<int>& nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
};