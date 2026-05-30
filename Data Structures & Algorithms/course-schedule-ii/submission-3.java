class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];

        for(int i=0;i<pre.length;i++){
            int a = pre[i][0], b = pre[i][1];
            indegree[a]++;
            adj.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }

        int[] res = new int[n];
        boolean[] safeSeq = new boolean[n];
        int k = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            res[k++] = node;

            for(int ele : adj.get(node)){
                indegree[ele]--;
                if(indegree[ele]==0) q.add(ele);
            }
        }

        // for(int i=1;i<n;i++){
        //     if(res[i]==res[i-1]) return new int[]{};
        // }
        if(k!=n) return new int[]{};

        return res;
    }
}
