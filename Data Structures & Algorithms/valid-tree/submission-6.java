class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: A valid tree must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }
        
        // Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        // Condition 2: The graph must be fully connected.
        // We start BFS from node 0 (always safe since n >= 1)
        Queue<Integer> isConnected = new LinkedList<>();
        boolean[] reachable = new boolean[n];
        
        isConnected.add(0);
        reachable[0] = true;
        int visitedCount = 0;
        
        while (!isConnected.isEmpty()) {
            int node = isConnected.poll();
            visitedCount++;
            
            for (int ele : adj.get(node)) {
                if (!reachable[ele]) {
                    reachable[ele] = true;
                    isConnected.add(ele);
                }
            }
        }
        
        // If we visited all n nodes, it's a valid tree
        return visitedCount == n;
    }
}
