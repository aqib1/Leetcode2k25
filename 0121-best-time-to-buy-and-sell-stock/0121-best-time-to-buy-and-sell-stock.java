class Solution {
    public int maxProfit(int[] prices) {
       int minFromLeft = prices[0];
       int maxProfit = 0;
       
       // Time complexity O(n) and space complexity O(1)
       for(int i = 1; i < prices.length; i++) {
            if(prices[i] <= minFromLeft) {
                minFromLeft = prices[i];
            } else if(prices[i] - minFromLeft > maxProfit) {
                maxProfit = prices[i] - minFromLeft;
            }
       }

       return maxProfit;
    }
}