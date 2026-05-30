class Solution {
    public boolean validTree(int n, int[][] edges) {
        // condition1: a valid tree must have exactly n-1 edges
        if(edges.length != n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int a = edges[i][0], b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // condition2: the graph must be fully connected.
        // we start bfs from node 0 (always since n>=1)
        Queue<Integer> isConnected = new LinkedList<>();
        boolean[] reachable = new boolean[n];
        isConnected.add(0);
        reachable[0] = true;
        int visitedCount = 0;

        while(!isConnected.isEmpty()){
            int node = isConnected.poll();
            visitedCount += 1;

            for(int ele : adj.get(node)){
                if(!reachable[ele]){
                    reachable[ele] = true;
                    isConnected.add(ele);
                }
            }
        }

        return visitedCount==n;
    }
}
