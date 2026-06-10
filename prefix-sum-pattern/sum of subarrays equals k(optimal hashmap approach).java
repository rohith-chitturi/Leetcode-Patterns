class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        Map<Integer,Integer> sumfreq=new HashMap<>();
        int sum=0;
        sumfreq.put(0,1);//there is one sub array with sum 0 that is an empty sub array
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int logic=sum-k;
            int frequency=sumfreq.getOrDefault(logic,0);//how many times we have seen sum-k
            count+=frequency;
            sumfreq.put(sum,sumfreq.getOrDefault(sum,0)+1);

        }
        return count;
    }
}
