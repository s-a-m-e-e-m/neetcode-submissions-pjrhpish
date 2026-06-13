class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = 1, curMin = 1;

        for(int num : nums){
            int tmp = num*curMax;
            curMax = Math.max(Math.max(tmp, num*curMin), num);
            curMin = Math.min(Math.min(tmp, num*curMin), num);
            res = Math.max(res, curMax);
        }

        return res;
    }
}
