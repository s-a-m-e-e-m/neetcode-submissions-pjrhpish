class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islands = 0, neighbours = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) {
                    islands++;
                    if(i+1<m && grid[i+1][j]==1) neighbours++;
                    if(j+1<n && grid[i][j+1]==1) neighbours++;
                }
            }
        }

        return 4*islands - 2*neighbours;
    }
}