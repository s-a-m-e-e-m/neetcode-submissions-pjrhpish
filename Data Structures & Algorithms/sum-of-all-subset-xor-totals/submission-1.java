class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int i, int total){
        if(i==nums.length) return total;
        return dfs(nums, i+1, nums[i]^total) + dfs(nums, i+1, total);
    }
}