import java.util.*;
class Solution {
    class Interval {
        int l, r, weight, index;
        public Interval(int l, int r, int weight, int index) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.index = index;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(intervals.get(i).get(0), intervals.get(i).get(1), intervals.get(i).get(2), i);
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a.r, b.r));
        long[][] dpWeight = new long[5][n];
        List<Integer>[][] dpIndices = new ArrayList[5][n];
        for (int c = 1; c <= 4; c++) {
            for (int i = 0; i < n; i++) {
                dpIndices[c][i] = new ArrayList<>();
            }
        }
        for (int i = 0; i < n; i++) {
            int j = binarySearch(arr, i, arr[i].l);
            for (int c = 1; c <= 4; c++) {
                long w1 = (i > 0) ? dpWeight[c][i-1] : 0;
                List<Integer> list1 = (i > 0) ? dpIndices[c][i-1] : new ArrayList<>();
                long w2 = arr[i].weight;
                List<Integer> prevList = new ArrayList<>();
                if (j != -1 && c>1) {
                    w2 += dpWeight[c-1][j];
                    prevList = dpIndices[c-1][j];
                }
                List<Integer> list2 = new ArrayList<>(prevList);
                list2.add(arr[i].index);
                Collections.sort(list2); 
                if (w1 > w2) {
                    dpWeight[c][i] = w1;
                    dpIndices[c][i] = list1;
                } else if (w2 > w1) {
                    dpWeight[c][i] = w2;
                    dpIndices[c][i] = list2;
                } else {
                    if (compare(list1, list2) <= 0) {
                        dpWeight[c][i] = w1;
                        dpIndices[c][i] = list1;
                    } else {
                        dpWeight[c][i] = w2;
                        dpIndices[c][i] = list2;
                    }
                }
            }
        }
        List<Integer> res = dpIndices[4][n-1];
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
    private int binarySearch(Interval[] arr, int currIdx, int target) {
        int left = 0, right = currIdx - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].r < target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
    private int compare(List<Integer> l1, List<Integer> l2) {
        int minLen = Math.min(l1.size(), l2.size());
        for (int i = 0; i < minLen; i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return Integer.compare(l1.get(i), l2.get(i));
            }
        }
        return Integer.compare(l1.size(), l2.size());
    }
}