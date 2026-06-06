class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int minH = grid[0][0], maxH = grid[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                maxH = Math.max(maxH, grid[i][j]);
                minH = Math.min(minH, grid[i][j]);
            }
        }

        int l = minH, r = maxH;
        while(l<r){
            int m = (l+r)/2;
            if(dfs(grid, vis, n, 0, 0, m)) r = m;
            else l = m+1;

            for(boolean[] v : vis) Arrays.fill(v, false);
        }

        return r;
    }

    private boolean dfs(int[][] grid, boolean[][] vis, int n, int r, int c, int t){
        if(r<0 || c<0 || r>=n || c>=n || vis[r][c] || grid[r][c]>t) return false;

        if(r==n-1 && c==n-1) return true;
        
        vis[r][c] = true;
        return dfs(grid, vis, n, r+1, c, t) || 
               dfs(grid, vis, n, r-1, c, t) ||
               dfs(grid, vis, n, r, c+1, t) ||
               dfs(grid, vis, n, r, c-1, t);
    }
}
