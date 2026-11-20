class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;
        for (int x : nums) {
            int lenPlusOne = dp.getOrDefault(x, 0) + 1;
            dp.put(x + 1, Math.max(dp.getOrDefault(x + 1, 0), lenPlusOne));
            int lenSame = dp.getOrDefault(x - 1, 0) + 1;
            dp.put(x, Math.max(dp.getOrDefault(x, 0), lenSame));
            maxLen = Math.max(maxLen, Math.max(dp.get(x + 1), dp.get(x)));
        }
        return maxLen;
    }
}