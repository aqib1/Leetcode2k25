class Solution {
    private int limit;
    private final List<List<Integer>> output = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        this.limit = nums.length;
        var currentCombo = new ArrayList<Integer>();
        generateSubsetsBacktrack(0, currentCombo, nums);
        return output;
    }

    private void generateSubsetsBacktrack(int current, ArrayList<Integer> currentCombo, int[] nums) {
        output.add(new ArrayList<>(currentCombo));
        for(int i = current; i < limit; i++) {
            currentCombo.add(nums[i]);
            generateSubsetsBacktrack(i + 1, currentCombo, nums);
            currentCombo.removeLast();
        }
    }
}