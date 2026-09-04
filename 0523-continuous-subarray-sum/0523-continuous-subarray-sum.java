class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> remaindermap=new HashMap<>();
        remaindermap.put(0,-1);
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=sum%k;
            if(remaindermap.containsKey(rem)){//okkavela aa remainder map lo unte
                if(i-remaindermap.get(rem)>=2){//2nd condition length at least 2
                    return true;
                }
            }else{
                remaindermap.put(rem,i);
            }
        }
        return false;
    }
}