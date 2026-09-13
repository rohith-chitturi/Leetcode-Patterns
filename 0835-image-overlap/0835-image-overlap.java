class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) list1.add(new int[]{r, c});
                if (img2[r][c] == 1) list2.add(new int[]{r, c});
            }
        }
        Map<String, Integer> shiftCounts = new HashMap<>();
        int maxOverlap = 0;
        for (int[] p1 : list1) {
            for (int[] p2 : list2) {
                String vector = (p2[0] - p1[0]) + "," + (p2[1] - p1[1]);
                int count = shiftCounts.getOrDefault(vector, 0) + 1;
                shiftCounts.put(vector, count);
                maxOverlap = Math.max(maxOverlap, count);
            }
        }
        return maxOverlap;
    }
}