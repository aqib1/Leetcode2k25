class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        target_map = {}

        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in target_map:
                return [i, target_map[complement]]
            else:
                target_map[nums[i]] = i

        return []
        