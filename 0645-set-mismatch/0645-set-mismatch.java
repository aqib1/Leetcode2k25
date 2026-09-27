class Solution {
    public int[] findErrorNums(int[] nums) {
        var visited = new boolean[nums.length + 1];
        var a = 0; var b = 0;
        for(int i : nums) {
            if(visited[i]) {
                a = i;
            }
            visited[i] = true;
        }

        for(int i = 1; i < visited.length; i++) {
            if(!visited[i]) {
                b = i;
                break;
            }
        }

        return new int[] {a, b};
    }
}