class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
            int freebies = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    freebies++;
                }
            }
            gain[i] = 1 + freebies;
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            if (price > budget) continue;

            for (int c = budget; c >= price; c--) {
                dp[c] = Math.max(dp[c], dp[c - price] + gain[i]);
            }
        }

        int maxItems = 0;
        for (int c = 0; c <= budget; c++) {
            int remainingBudget = budget - c;
            int extraCopies = (minPrice <= remainingBudget) ? (remainingBudget / minPrice) : 0;
            maxItems = Math.max(maxItems, dp[c] + extraCopies);
        }

        return maxItems;
    }
}