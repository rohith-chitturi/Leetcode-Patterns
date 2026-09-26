class Solution {
    public int findKthPositive(int[] arr, int k) {
        // List<Integer> missing=new ArrayList<>();
        // int n=arr.length;
        // int min=1;
        // int max=arr[n-1]+k;
        // List<Integer> array=new ArrayList<>();
        // for(int i:arr){
        //     array.add(i);
        // }
        // for(int i=min;i<=max;i++){
        //     if(!array.contains(i)){
        //         missing.add(i);
        //     }
        // }
        // int[] res=new int[missing.size()];
        // for(int i=0;i<res.length;i++){
        //     res[i]=missing.get(i);
        // }
        // return res[k-1];
        //above entire is brute force
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low+k;
    }
}