class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        int left=0;
        int right=n-1;
        Arrays.sort(people);
        int ans=0;
        while(left<=right){
            if(people[left]+people[right]<=limit){
                left+=1;
                right-=1;
                ans+=1;
            }
            else{
                right-=1;
                ans+=1;
            }
        }
        return ans;
    }
}