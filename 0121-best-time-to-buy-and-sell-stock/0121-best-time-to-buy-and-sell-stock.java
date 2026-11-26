class Solution {
    public int maxProfit(int[] prices) {
       if(prices == null || prices.length == 1)
            return 0;

        int maxProfit = 0;
        int minFromLeft = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if(minFromLeft >= prices[i]) {
                minFromLeft = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minFromLeft);
            }
        }

        return maxProfit;
    }
}