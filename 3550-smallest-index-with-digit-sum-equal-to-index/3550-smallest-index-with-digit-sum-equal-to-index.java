class Solution {
    public int smallestIndex(int[] nums) {
        List<Integer> digitlist=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            int digitsum=0;
            while(temp>0){
                int digit=temp%10;
                digitsum+=digit;
                temp=temp/10;
            }
            if(i==digitsum){
                return i;
            }
        }
        return -1;
    }
}