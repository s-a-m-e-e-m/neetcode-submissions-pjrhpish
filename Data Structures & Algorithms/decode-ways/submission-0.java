class Solution {
    private int solve(int i, int n, String s, int[] dp){
        if(dp[i] != -1) return dp[i];

        if(i==n) return dp[i] = 1;
        if(s.charAt(i)=='0') return dp[i] = 0;

        int res = solve(i+1, n, s, dp);
        if(i+1 < n){
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6'))
                res += solve(i+2, n, s, dp);
        }

        return dp[i] = res;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, n, s, dp);
    }
}
