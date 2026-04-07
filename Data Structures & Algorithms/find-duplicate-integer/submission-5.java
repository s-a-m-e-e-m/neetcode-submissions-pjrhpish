class Solution {
    public int findDuplicate(int[] nums) {
        // using O(1) extra space in O(n) time

        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] < 0) return Math.abs(nums[i]);
            nums[idx] *= -1;
        }

        return -1;
    }
}
