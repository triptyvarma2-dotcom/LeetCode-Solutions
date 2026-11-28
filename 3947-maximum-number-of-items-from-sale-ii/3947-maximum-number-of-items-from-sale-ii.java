import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        // Count frequency of each factor
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Count how many item factors are multiples of each factor
        int[] gain = new int[maxFactor + 1];

        for (int i = 1; i <= maxFactor; i++) {
            for (int j = i; j <= maxFactor; j += i) {
                gain[i] += freq[j];
            }
            gain[i]--; // Exclude the item itself
        }

        // Sort items by price
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long remainingBudget = budget;
        long answer = 0;

        // Buy items that give 2 copies per unit of cost (paid + free)
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (price >= 2L * minPrice) {
                break;
            }

            if (gain[factor] <= 0) {
                continue;
            }

            long count = Math.min(gain[factor], remainingBudget / price);

            answer += 2 * count;
            remainingBudget -= count * price;
        }

        // Use remaining budget to buy cheapest items (1 copy per purchase)
        answer += remainingBudget / minPrice;

        return (int) answer;
    }
}