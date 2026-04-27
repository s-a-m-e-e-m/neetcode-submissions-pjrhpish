class Solution {
    public int maxSubArray(int[] nums) {
        int minSum = Integer.MIN_VALUE, currSum = 0;
        for(int n : nums){
            currSum += n;
            minSum = Math.max(minSum, currSum);
            if(currSum < 0) currSum = 0;
        }
        return minSum;
    }
}
