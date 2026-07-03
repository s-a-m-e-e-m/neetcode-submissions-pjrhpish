class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return solve(0, 0, s, p, dp);
    }

    private boolean solve(int i, int j, String s, String p, int[][] dp){
        if(j==p.length()) return i==s.length();
        if(dp[i][j]!=-1) return dp[i][j]==1;

        boolean ans = false;

        boolean first_match = (i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));

        if(j+1<p.length() && p.charAt(j+1)=='*'){
            ans = (solve(i, j+2, s, p, dp) || (first_match && solve(i+1, j, s, p, dp)));
        }
        else{
            ans = first_match && solve(i+1, j+1, s, p, dp);
        }

        dp[i][j] = ans ? 1 : 0;
        return dp[i][j] == 1;
    }
}
