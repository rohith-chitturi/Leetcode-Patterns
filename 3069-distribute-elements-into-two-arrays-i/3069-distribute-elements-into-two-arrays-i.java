class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        int n1=1;
        int n2=1;
        arr1[0]=nums[0];
        arr2[0]=nums[1];
        for(int i=2;i<n;i++){
            if(arr1[n1-1]>arr2[n2-1]){
                arr1[n1]=nums[i];
                n1++;
            }else{
                arr2[n2]=nums[i];
                n2++;
            }
        }
        int[] res=new int[n];
        for(int i=0;i<n1;i++){
            res[i]=arr1[i];
        }
        for(int i=0;i<n2;i++){
            res[n1+i]=arr2[i];
        }
        return res;
    }
}