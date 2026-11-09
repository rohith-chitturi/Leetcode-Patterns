import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }
        int[] requestCount = new int[k];
        int maxRequests = 0;
        for (int i = 0; i < arrival.length; i++) {
            int currTime = arrival[i];
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currTime) {
                int[] freed = busyServers.poll();
                availableServers.add(freed[1]);
            }
            if (availableServers.isEmpty()) {
                continue;
            }           
            Integer serverId = availableServers.ceiling(i % k);
            if (serverId == null) {
                serverId = availableServers.first();
            }
            availableServers.remove(serverId);
            busyServers.offer(new int[] { currTime + load[i], serverId });
            requestCount[serverId]++;
            maxRequests = Math.max(maxRequests, requestCount[serverId]);
        }
        List<Integer> busiest = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCount[i] == maxRequests) {
                busiest.add(i);
            }
        }
        return busiest;
    }
}