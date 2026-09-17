class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int answer=0;
        for(int k=0;k<32;k++){
            int count=0;
            for(int j:nums){
                int x=j&(1<<k);
                if(x!=0){
                    count++;
                }
            }
            if(count%3==1){
                answer=answer|(1<<k);
            }
        }
        return answer;
    }
}