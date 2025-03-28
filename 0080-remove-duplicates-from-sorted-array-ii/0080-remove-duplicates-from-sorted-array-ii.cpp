class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        if(nums.size() <= 2) {
          return nums.size();
        }
        int slow = 2; int fast = 2;

        while(fast < nums.size()) {
          if(nums[slow - 2] == nums[fast]) {
            fast++;
          } else {
            nums[slow++] = nums[fast++];
          }
        }

        return slow;
    }
};