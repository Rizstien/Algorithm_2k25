class Solution {
    public int maxProfit(int[] prices) {
        int bPrice=prices[0],profit=0;

        for(int i=1;i<prices.length;i++){
            if(prices[i] < bPrice){
                bPrice = prices[i];
            }

            profit = Math.max(profit, prices[i]-bPrice);
        }

/*
        // B.F O(n^2) approach
        for(int i=0;i<prices.length;i++){
            if(prices[i] > bPrice && i > bDay){
                profit = Math.max(profit,prices[i] - bPrice);
            }
        }

        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                profit = Math.max(profit,prices[j]-prices[i]);
            }
        }
*/
        return profit;
    }
}