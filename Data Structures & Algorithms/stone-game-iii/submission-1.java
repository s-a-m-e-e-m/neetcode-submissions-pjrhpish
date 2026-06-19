class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int res = dfs(0, n, stoneValue, dp);
        if(res==0) return "Tie";
        return res>0 ? "Alice" : "Bob";
    }

    private int dfs(int i, int n, int[] stoneValue, int[] dp){
        if(i>=n) return 0;
        if(dp[i] != Integer.MIN_VALUE) return dp[i];

        int res = Integer.MIN_VALUE, total = 0;
        for(int j=i;j<Math.min(i+3, n);j++){
            total += stoneValue[j];
            res = Math.max(res, total-dfs(j+1, n, stoneValue, dp));
        }

        dp[i] = res;
        return res;
    }
}