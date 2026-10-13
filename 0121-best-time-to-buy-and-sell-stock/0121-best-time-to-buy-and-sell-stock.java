class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Track the lowest buying price seen so far
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // Update max profit if selling today gives a higher return
            }
        }

        return maxProfit;
    }
}