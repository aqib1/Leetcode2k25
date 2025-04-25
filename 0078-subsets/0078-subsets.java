class Solution {
    private int limit;
    private final List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.limit = nums.length;
        List<Integer> currentCombo = new ArrayList<>();
        createSubsetsUsingBacktracking(0, currentCombo, nums);
        return output;
    }

    private void createSubsetsUsingBacktracking(int current, List<Integer> currentCombo, int[] data) {
        output.add(new ArrayList<>(currentCombo));
        for (int i = current; i < limit; i++) {
            currentCombo.add(data[i]);
            createSubsetsUsingBacktracking(i + 1, currentCombo, data);
            currentCombo.removeLast();
        }
    }
}