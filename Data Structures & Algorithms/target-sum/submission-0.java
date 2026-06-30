class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, target, nums);
    }

    private int solve(int i, int target, int[] nums){
        if(i==nums.length){
            if(target==0) return 1;
            return 0;
        } 

        int plus = solve(i+1, target+nums[i], nums);
        int minus = solve(i+1, target-nums[i], nums);

        return plus+minus;
    }
}
