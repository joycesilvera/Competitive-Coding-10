// Time complexity: O(n) where n is the number of days in the prices array.
// Space complexity: O(1) since we are using a constant amount of space for the maxProfit variable.

// Intuition: The problem is to find the maximum profit that can be made by buying and selling stocks on different days. 
// We can achieve this by iterating through the prices array and adding the profit from each upward trend 
// (i.e., when the price on the next day is higher than the current day).
// The approach is to sum up all the positive differences between consecutive days' prices,
// which gives us the total profit we can make by buying on one day and selling on the next day 
// whenever there is a price increase.

public class BestTimeToBuyStocksII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i])
                maxProfit += prices[i + 1] - prices[i];
        }
        return maxProfit;
    }
}
