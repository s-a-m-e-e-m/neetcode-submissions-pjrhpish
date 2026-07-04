class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1) return true;

        int currJumpCapacity = nums[0];

        for(int i=1;i<n-1;i++){
            if(currJumpCapacity <= 0) return false;
            currJumpCapacity = Math.max(currJumpCapacity-1, nums[i]);
        }

        return currJumpCapacity>0;
    }
}
