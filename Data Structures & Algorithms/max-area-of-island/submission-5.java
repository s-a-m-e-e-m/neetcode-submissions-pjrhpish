class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxArea = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int[] area = {0};
                    dfs(i, j, m, n, grid, area);
                    maxArea = Math.max(maxArea, area[0]);
                }
            }
        }

        return maxArea;
    }

    private void dfs(int i, int j, int m, int n, int[][] grid, int[] area){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0) return;

        grid[i][j] = 0;
        area[0] += 1;

        dfs(i, j+1, m, n, grid, area);
        dfs(i+1, j, m, n, grid, area);
        dfs(i, j-1, m, n, grid, area);
        dfs(i-1, j, m, n, grid, area);
    }
}
