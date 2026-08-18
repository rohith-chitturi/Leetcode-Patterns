class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer,Integer> windowfreq=new HashMap<>();
        Map<Integer,Integer> overallwindowcount=new HashMap<>();
        for(int i=0;i<k;i++){
            windowfreq.put(nums[i],windowfreq.getOrDefault(nums[i],0)+1);
        }
        for(int key:windowfreq.keySet()){
            overallwindowcount.put(key,overallwindowcount.getOrDefault(key,0)+1);
        }
        for(int i=k;i<nums.length;i++){
            windowfreq.put(nums[i],windowfreq.getOrDefault(nums[i],0)+1);
            int left = nums[i - k];
            windowfreq.put(left, windowfreq.get(left) - 1);
            if (windowfreq.get(left) == 0) {
                windowfreq.remove(left);
            }
            for(int key:windowfreq.keySet()){
                overallwindowcount.put(key,overallwindowcount.getOrDefault(key,0)+1);
            }
        }
        int maxMissing = -1;
        for (Map.Entry<Integer, Integer> entry : overallwindowcount.entrySet()) {
            if (entry.getValue() == 1) {
                maxMissing = Math.max(maxMissing, entry.getKey());
            }
        }
        return maxMissing;
    }
}