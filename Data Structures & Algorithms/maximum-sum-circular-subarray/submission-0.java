class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int res = nums[0];

        for(int i=0;i<n;i++){
            int curSum = 0;
            for(int j=i;j<i+n;j++){
                curSum += nums[j%n];
                res = Math.max(res, curSum);
            }
        }

        return res;
    }
}