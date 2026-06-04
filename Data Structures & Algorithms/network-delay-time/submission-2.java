class Solution {
    private int[] dijkstra(int src, int n, List<List<int[]>> adj){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);

        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[src] = 0;
        pq.offer(new int[]{src, 0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0], d = node[1];

            if(time[u] < d) continue;

            for(int[] neigh : adj.get(u)){
                int v = neigh[0], w = neigh[1];

                if(time[u]+w < time[v]){
                    time[v] = time[u]+w;
                    pq.offer(new int[]{v, time[v]});
                }
            }
        }

        return time;
    }
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0], v = time[1], w = time[2];
            adj.get(u).add(new int[]{v, w});
        }

        int[] minTime = dijkstra(src, n, adj);
        int res = 0;
        for(int i=1;i<=n;i++){
            if(minTime[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, minTime[i]);
        }

        return res;
    }
}
