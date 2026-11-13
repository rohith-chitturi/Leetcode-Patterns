class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n=nums.length;
        long totalCount=0;
        Deque<Integer> deque=new ArrayDeque<>();
        long currentOperations=0;
        long[] cost=new long[n];
        int left=n-1;
        for(int right=n-1;right>=0;right--){
            while(!deque.isEmpty()&&nums[deque.peekFirst()]<nums[right]){
                int index=deque.pollFirst();
                int nextBoundary=deque.isEmpty()?left+1:deque.peekFirst();
                long count=nextBoundary-index;
                currentOperations+=count*(nums[right]-nums[index]);
            }
            deque.addFirst(right);
            while(currentOperations>k){
                int ci=deque.peekLast();
                currentOperations-=(nums[ci]-nums[left]);
                if(ci==left){
                    deque.pollLast();
                }
                left--;
            }
            totalCount+=(left-right+1);
        }
        return totalCount;
    }
}