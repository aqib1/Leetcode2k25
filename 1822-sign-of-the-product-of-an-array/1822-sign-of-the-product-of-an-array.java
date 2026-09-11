class Solution {
    public int arraySign(int[] nums) {
        var negativeCount = 0;
        for(var num: nums) {
            if(num == 0) {
                // if any of the num is 0, the whole product will be 0
                // thus result will be 0.
                return 0;
            }

            if(num < 0)
                negativeCount++;
        }

        // if negativeCount is event it will make product positive
        return negativeCount % 2 == 0 ? 1 : -1;
    }
}