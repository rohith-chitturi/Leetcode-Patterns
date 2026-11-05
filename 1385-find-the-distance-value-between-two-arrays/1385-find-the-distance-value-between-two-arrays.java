class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        boolean correct=true;
        for(int i=0;i<arr1.length;i++){
            int num=arr1[i];
            for(int j=0;j<arr2.length;j++){
                if(Math.abs(num-arr2[j])<=d){
                    correct=false;
                    break;
                }
            }
            if(correct){
                count++;
            }
            correct=true;
        }
        return count;
    }
}