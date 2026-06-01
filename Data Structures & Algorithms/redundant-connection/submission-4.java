class Solution {

    int[] parent;
    int[] rank;
    int components;

    public int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length;
        this.parent = new int[nodes+1];
        this.rank = new int[nodes+1];
        this.components = nodes;
        for(int i=0;i<nodes;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges){
            if(!union(edge[0], edge[1]))
                return new int[]{edge[0], edge[1]};
        }

        return new int[0];
    }

    private int findParent(int node){
        if(node == parent[node]) return node;

        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    private boolean union(int node1, int node2){
        int rootParent1 = findParent(node1);
        int rootParent2 = findParent(node2);

        if(rootParent1 == rootParent2) return false;

        components--;
        if(rank[rootParent1] < rank[rootParent2]){
            parent[rootParent1] = rootParent2;
            rank[rootParent2] += rank[rootParent1];
        }
        else{
            parent[rootParent2] = rootParent1;
            rank[rootParent1] += rank[rootParent2];
        }

        return true;
    }
}
