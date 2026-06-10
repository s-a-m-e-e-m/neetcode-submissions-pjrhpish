class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int case1 = solve(0, n-2, nums);
        int case2 = solve(1, n-1, nums);
        return Math.max(case1, case2);
    }

    private int solve(int start, int end, int[] nums){
        if(start==end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        for(int i=start+2;i<=end;i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }

        return dp[end];
    }
}
