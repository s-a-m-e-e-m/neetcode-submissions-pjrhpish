class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islands = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(i, j, m, n, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int i, int j, int m, int n, char[][] grid){
        if(i>=m || i<0 || j>=n || j<0 || grid[i][j]=='0') return;

        grid[i][j] = '0';
        dfs(i, j+1, m, n, grid);
        dfs(i+1, j, m, n, grid);
        dfs(i, j-1, m, n, grid);
        dfs(i-1, j, m, n, grid);
    }
}
