import java.util.Map;
import java.util.TreeMap;
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxFactor = 0;
        long minPrice = Long.MAX_VALUE;
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }
        int[] factorCount = new int[maxFactor + 1];
        for (int[] item : items) {
            factorCount[item[0]]++;
        }
        int[] multiplesCount = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (factorCount[f] == 0) {
                continue;
            }
            for (int mult = f; mult <= maxFactor; mult += f) {
                multiplesCount[f] += factorCount[mult];
            }
        }
        TreeMap<Long, Long> boostedUnits = new TreeMap<>();
        long maxProfitablePrice = 2L * minPrice;
        for (int[] item : items) {
            int f = item[0];
            long price = item[1];
            int freebiesAvailable = multiplesCount[f] - 1;
            if (freebiesAvailable > 0 && price <= maxProfitablePrice) {
                boostedUnits.merge(price, (long) freebiesAvailable, Long::sum);
            }
        }
        long remainingBudget = budget;
        long totalItems = 0;
        for (Map.Entry<Long, Long> entry : boostedUnits.entrySet()) {
            long price = entry.getKey();
            long available = entry.getValue();
            if (remainingBudget < price) {
                break;
            }
            long buy = Math.min(available, remainingBudget / price);
            totalItems += 2L * buy;
            remainingBudget -= buy * price;
        }
        totalItems += remainingBudget / minPrice;
        return (int) totalItems;
    }
}