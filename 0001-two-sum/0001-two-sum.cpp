class Solution {
    // Time complexity O(n) and space complexity O(n)
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> hash;
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums[i];
            if (hash.find(complement) != hash.end() && hash[complement] != i) {
                return {i, hash[complement]};
            }
            hash[nums[i]] = i;
        }
        // If no valid pair is found, return an empty vector
        return {};
    }
};