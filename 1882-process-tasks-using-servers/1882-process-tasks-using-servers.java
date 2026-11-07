class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }
        long currTime = 0;
        for (int j = 0; j < m; j++) {
            currTime = Math.max(currTime, j);
            if (freeServers.isEmpty() && busyServers.peek()[0] > currTime) {
                currTime = busyServers.peek()[0];
            }
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currTime) {
                int[] busy = busyServers.poll();
                freeServers.offer(new int[]{busy[1], busy[2]});
            }
            int[] bestServer = freeServers.poll();
            int serverIndex = bestServer[1];
            int serverWeight = bestServer[0];
            ans[j] = serverIndex;
            busyServers.offer(new int[]{(int)currTime + tasks[j], serverWeight, serverIndex});
        }
        return ans;
    }
}