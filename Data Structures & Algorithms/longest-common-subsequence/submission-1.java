class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int[] d : dp) Arrays.fill(d, -1);

        return solve(0, 0, m, n, text1, text2, dp);
    }

    private int solve(int i, int j, int m, int n, String s1, String s2, int[][] dp){
        if(i>=m || j>=n ) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j))
            dp[i][j] = 1 + solve(i+1, j+1, m, n, s1, s2, dp);

        else 
            dp[i][j] = Math.max(solve(i+1, j, m, n, s1, s2, dp), solve(i, j+1, m, n, s1, s2, dp));

        return dp[i][j];
    }
}
