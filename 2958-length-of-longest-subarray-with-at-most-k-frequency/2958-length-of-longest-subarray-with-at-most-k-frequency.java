class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int left=0;
        int n=nums.length;
        int max=0;
        for(int right=0;right<n;right++){
            int num=nums[right];
            map.put(num,map.getOrDefault(num,0)+1);
            while(map.get(num)>k){
                int a=nums[left];
                map.put(a,map.getOrDefault(a,0)-1);
                left++;
            }
            int len=right-left+1;
            max=Math.max(max,len);
        }
        return max;
    }
}