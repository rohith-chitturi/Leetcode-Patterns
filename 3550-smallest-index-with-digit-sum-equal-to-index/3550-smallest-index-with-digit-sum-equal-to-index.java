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
            digitlist.add(digitsum);
        }
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<digitlist.size();i++){
            if(i==digitlist.get(i)){
                smallest=Math.min(smallest,i);
            }
        }
        if(smallest==Integer.MAX_VALUE){
            return -1;
        }
        return smallest;
    }
}