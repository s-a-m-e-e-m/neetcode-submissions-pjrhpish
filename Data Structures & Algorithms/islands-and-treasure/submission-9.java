class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    dfs(i, j+1, m, n, grid, 1);
                    dfs(i+1, j, m, n, grid, 1);
                    dfs(i, j-1, m, n, grid, 1);
                    dfs(i-1, j, m, n, grid, 1);
                }
            }
        }
    }

    private void dfs(int i, int j, int m, int n, int[][] grid, int dis){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==-1 || grid[i][j]==0) return;

        if(dis < grid[i][j]){
            grid[i][j] = dis;

            dfs(i, j+1, m, n, grid, dis+1);
            dfs(i+1, j, m, n, grid, dis+1);
            dfs(i, j-1, m, n, grid, dis+1);
            dfs(i-1, j, m, n, grid, dis+1);
        } 
    }
}
