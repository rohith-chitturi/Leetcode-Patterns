class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m=queries.length;
        int[][] sortedQueries=new int[m][2];
        for(int i=0;i<m;i++){
            sortedQueries[i][0]=queries[i];
            sortedQueries[i][1]=i;
        }
        Arrays.sort(sortedQueries,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(logs,(a,b)->Integer.compare(a[1],b[1]));
        int[] ans=new int[m];
        Map<Integer,Integer> serverCount=new HashMap<>();
        int left=0;
        int right=0;
        int numLogs=logs.length;
        for(int i=0;i<m;i++){
            int qTime=sortedQueries[i][0];
            int origIdx=sortedQueries[i][1];
            int windowSort=qTime-x;
            int windowEnd=qTime;
            while(right<numLogs && logs[right][1]<=windowEnd){
                int serverId=logs[right][0];
                serverCount.put(serverId,serverCount.getOrDefault(serverId,0)+1);
                right++;
            }
            while(left<numLogs && logs[left][1]<windowSort){
                int serverId=logs[left][0]; 
                serverCount.put(serverId,serverCount.get(serverId)-1);
                if(serverCount.get(serverId)==0){
                    serverCount.remove(serverId);
                }
                left++;
            }
            ans[origIdx]=n-serverCount.size();
        }
        return ans;
    }
}