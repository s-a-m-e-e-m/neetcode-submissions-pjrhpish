class Solution {

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int[] d : dp) Arrays.fill(d, -1);

        int maxLen = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maxLen = Math.max(maxLen, dfs(i, j, m, n, Integer.MIN_VALUE, matrix, dp));
            }
        }

        return maxLen;
    }

    private int dfs(int i, int j, int m, int n, int prevVal, int[][] matrix, int[][] dp){
        if(i<0 || i>=m || j<0 || j>=n || matrix[i][j]<=prevVal) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int res = 1;
        for(int[] d : dirs){
            res = Math.max(res, 1+dfs(i+d[0], j+d[1], m, n, matrix[i][j], matrix, dp));
        }

        return dp[i][j] = res;
    }
}
