class Solution {
    class DSU{
        int[] parent;
        int[] rank;

        public DSU(int n){
            this.parent = new int[n];
            this.rank = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int findParent(int node){
            if(node == parent[node]) return node;

            parent[node] = findParent(parent[node]);
            return parent[node];
        }

        void union(int node1, int node2){
            int rp1 = findParent(node1), rp2 = findParent(node2);

            if(rp1 == rp2) return;
            
            if(rank[rp1] < rank[rp2]){
                parent[rp1] = rp2;
                rank[rp2] += rank[rp1];
            }
            else{
                parent[rp2] = rp1;
                rank[rp1] += rank[rp2];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DSU ds = new DSU(n);
        Map<String, Integer> map = new HashMap<>();

        for(int j=0;j<n;j++){
            List<String> list = accounts.get(j);
            int m = list.size();

            for(int i=1;i<m;i++){
                String str = list.get(i);
                if(map.containsKey(str)) ds.union(map.get(str), j);
                else map.put(str, j);
            }
        }

        ArrayList<String>[] mergedMails = new ArrayList[n];
        for(int i=0;i<n;i++){
            mergedMails[i] = new ArrayList<>();
        }

        for(Map.Entry<String, Integer> it : map.entrySet()){
            String mail = it.getKey();
            int node = ds.findParent(it.getValue());
            mergedMails[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(mergedMails[i].size()==0) continue;
            List<String> temp = new ArrayList<>();
            Collections.sort(mergedMails[i]);
            temp.add(accounts.get(i).get(0));
            int k = mergedMails[i].size();
            for(int j=0;j<k;j++){
                temp.add(mergedMails[i].get(j));
            }

            ans.add(temp);
        }

        return ans;
    }
}