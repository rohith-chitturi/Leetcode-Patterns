class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        int seqsum=nums[0];
        List<Integer> al=new ArrayList<>();
        for(int i:nums){
            al.add(i);
        }
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                seqsum+=nums[i];
            }else{
                break;
            }
        }
        while(al.contains(seqsum)){
            seqsum++;
        }
        return seqsum;
    }
}