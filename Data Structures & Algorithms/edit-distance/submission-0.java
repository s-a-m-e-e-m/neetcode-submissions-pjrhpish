class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];

        for(int[] d : dp) Arrays.fill(d, -1);

        return solve(m-1, n-1, word1, word2, dp);
    }

    private int solve(int i, int j, String s1, String s2, int[][] dp){
        if(i==-1) return j+1;
        if(j==-1) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j))
            dp[i][j] = solve(i-1, j-1, s1, s2, dp);

        else{
            int del = solve(i-1, j, s1, s2, dp);
            int rep = solve(i-1, j-1, s1, s2, dp);
            int ins = solve(i, j-1, s1, s2, dp);

            dp[i][j] = 1 + Math.min(del, Math.min(rep, ins));
        }

        return dp[i][j];
    }
}
