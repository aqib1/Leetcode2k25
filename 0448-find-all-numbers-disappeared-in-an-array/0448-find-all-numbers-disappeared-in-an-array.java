class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        var response = new ArrayList<Integer>();
        var visited = new boolean[nums.length + 1];
        for (int n : nums)
            visited[n] = true;

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                response.add(i);
            }
        }

        return response;
    }
}