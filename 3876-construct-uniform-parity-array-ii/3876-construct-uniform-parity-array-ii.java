class Solution {
    public boolean uniformArray(int[] nums1) {
        int minimumValue=Integer.MAX_VALUE;
        boolean hasOdd=false;
        for(int num:nums1){
            if(num<minimumValue){
                minimumValue=num;
            }
            if(num % 2!=0){
                hasOdd=true;
            }
        }
        if(minimumValue%2!=0){
            return true;
        }
        return !hasOdd;
    }
}