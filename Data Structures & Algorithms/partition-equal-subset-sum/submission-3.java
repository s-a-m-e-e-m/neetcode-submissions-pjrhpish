class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%2 != 0) return false;

        boolean[] dp = new boolean[nums.length];
        sum /= 2;

        return targetSum(0, sum, nums, dp);
    }

    private boolean targetSum(int i, int sum, int[] nums, boolean[] dp){
        if(i==nums.length){
            return sum==0;
        }
        if(sum==0) return dp[i] = true;
        if(dp[i]) return dp[i];

        boolean take = targetSum(i+1, sum-nums[i], nums, dp);
        boolean notTake = targetSum(i+1, sum, nums, dp);

        return dp[i] = take || notTake;
    }
}
