class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d=arr[1]-arr[0];
        for(int i=1;i<arr.length;i++){
            int diff=arr[i]-arr[i-1];
            if(diff!=d){
                return false;
            }
        }
        return true;
    }
}