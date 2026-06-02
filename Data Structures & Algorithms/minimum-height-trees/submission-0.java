class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int minHgt = n;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            int curhgt = dfs(i, -1, adj);
            if(curhgt == minHgt) result.add(i);
            else if(curhgt < minHgt){
                result = new ArrayList<>();
                result.add(i);
                minHgt = curhgt;
            }
        }

        return result;
    }

    private int dfs(int node, int parent, List<List<Integer>> adj){
        int hgt = 0;
        for(int nei : adj.get(node)){
            if(nei == parent) continue;
            hgt = Math.max(hgt, 1 + dfs(nei, node, adj));
        }

        return hgt;
    }
}