class Solution:
    def numOfSubarrays(self, arr: list[int]) -> int:
        n=len(arr)
        prefix=[0]*(n+1)
        for i in range(1,n+1):
            prefix[i]=prefix[i-1]+arr[i-1]
        evens=0
        odds=0
        mod=10**9+7
        for i in prefix:
            if(i%2==0):
                evens+=1
            else:
                odds+=1
        return (evens*odds)%mod